package com.example.kirikiri.controller;

import com.example.kirikiri.domain.*;
import com.example.kirikiri.service.BoardService;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/all")
    public String getList(BoardDTO boardDTO, Integer page, Model model){
        if(page == null) page = 1;
        Integer pageTotal = boardService.getCountAll();
        model.addAttribute("boards", boardService.getListAll(page));
        model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
        boardDTO.setCategoryName("All");
        return "/community";
    }
    @GetMapping("/board")
    public String moveCategory(BoardDTO boardDTO, Integer page, Model model){
        BoardVO boardVO = boardDTO.changeBoardVO();
        Integer pageTotal;
        if(page == null) page = 1;
        boardDTO.setPage(page);
        if(boardDTO.getSortType() == 1) {
            if(boardDTO.getCategoryName().equals("All")){
                pageTotal = boardService.getCountAll();
                model.addAttribute("boards", boardService.getListAll(page));
                model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
            }
            else {
                if(boardDTO.getDetailCategoryName().isEmpty()) {
                    pageTotal = boardService.getCountCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByCategory(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
                else {
                    pageTotal = boardService.getCountDetailCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByDetailCategory(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
            }
        }
        if(boardDTO.getSortType() == 2) {
            if(boardDTO.getCategoryName().equals("All")){
                pageTotal = boardService.getCountAll();
                model.addAttribute("boards", boardService.getListAllOrderByLikes(page));
                model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
            } else{
                if(boardDTO.getDetailCategoryName().isEmpty()) {
                    pageTotal = boardService.getCountCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByCategoryOrderByLikes(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
                else {
                    pageTotal = boardService.getCountDetailCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByDetailCategoryOrderByLikes(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
            }
        }
        if(boardDTO.getSortType() == 3) {
            if(boardDTO.getCategoryName().equals("All")){
                pageTotal = boardService.getCountAll();
                model.addAttribute("boards", boardService.getListAllOrderByViews(page));
                model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
            } else {
                if(boardDTO.getDetailCategoryName().isEmpty()) {
                    pageTotal = boardService.getCountCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByCategoryOrderByViews(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
                else {
                    pageTotal = boardService.getCountDetailCategory(boardVO);
                    model.addAttribute("boards", boardService.getListByDetailCategoryOrderByViews(boardDTO));
                    model.addAttribute("pagination", new PageDTO().createPageBoardDTO(page, pageTotal));
                }
            }
        }

        return "/community";
    }

    @GetMapping("/new")
    public String addPost(BoardVO boardVO, UserVO userVO, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        UserVO user = userService.getUserVOById(userId);
        userVO.setUserNickname(user.getUserNickname());
        boardVO.setNationName(user.getUserNation());
        boardVO.setUserId(user.getUserId());
        return "/addPost";
    }
    @PostMapping("/new")
    public RedirectView addPost(BoardVO boardVO){
        boardService.add(boardVO);
        return new RedirectView("/board/all");
    }
    @GetMapping("/post")
    public String post(Long boardId, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        BoardVO boardVO = boardService.getBoard(boardId);
        boolean userCheck;
        boolean updateCheck;
        if(boardVO.getUserId().equals(userId)) userCheck = true;
        else userCheck = false;
        if(!boardVO.getBoardUpdateDate().equals(boardVO.getBoardRegisterDate())) updateCheck = true;
        else updateCheck = false;
        model.addAttribute("boardVO", boardVO);
        model.addAttribute("userCheck", userCheck);
        model.addAttribute("updateCheck", updateCheck);
        return "/post";
    }
    @GetMapping("/edit")
    public String editPost(Long boardId, Model model){
        BoardVO boardVO = boardService.getBoard(boardId);
        model.addAttribute("boardVO", boardVO);
        return "/editPost";
    }
    @PostMapping("/edit")
    public RedirectView editPost(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.edit(boardVO);
        redirectAttributes.addAttribute("boardId", boardVO.getBoardId());
        return new RedirectView("/board/post");
    }
    @GetMapping("/delete")
    public RedirectView deletePost(Long boardId) {
        boardService.delete(boardId);
        return new RedirectView("/board/all");
    }

    @GetMapping("/faq")
    public String FAQ(){
        return "/faq";
    }
    @GetMapping("/")
    public String main(){
        return "/mainPageHtml/index";
    }

        //    작성한 게시글 조회
    @GetMapping("/activity")
    public void getWrittenBoard(String userId, Integer page, Model model){
        PageBoardDTO pbt = new PageBoardDTO().createPageBoardDTO(page,255);
        model.addAttribute("pagination", pbt);
        model.addAttribute("boards", boardService.getWrittenBoard("kevs",pbt.getPage()));
    }
}
