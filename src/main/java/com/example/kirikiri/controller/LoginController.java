package com.example.kirikiri.controller;

import com.example.kirikiri.domain.LoginVO;
import com.example.kirikiri.mapper.LoginMapper;
import com.example.kirikiri.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="/member")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MemberService memberservice;

    @Autowired
    private BCryptPasswordEncoder pwEncoder;

    //회원가입 페이지 이동
    @RequestMapping(value="/join", method=RequestMethod.GET)
    public void loginGET() {
        logger.info("회원가입 페이지 진입");
    }

    //로그인 페이지 이동
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public void joinGET() {

        logger.info("로그인 페이지 진입");

    }

    /* 로그인 */
    @RequestMapping(value="login.do", method=RequestMethod.POST)
    public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{

        HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";

        MemberVO lvo = memberservice.memberLogin(member);	// 제출한아이디와 일치하는 아이디 있는지

        if(lvo != null) {			// 일치하는 아이디 존재시

            rawPw = member.getMemberPw();		// 사용자가 제출한 비밀번호
            encodePw = lvo.getMemberPw();		// 데이터베이스에 저장한 인코딩된 비밀번호

            if(true == pwEncoder.matches(rawPw, encodePw)) {		// 비밀번호 일치여부 판단

                lvo.setMemberPw("");					// 인코딩된 비밀번호 정보 지움
                session.setAttribute("member", lvo); 	// session에 사용자의 정보 저장
                return "redirect:/main";		// 메인페이지 이동


            } else {

                rttr.addFlashAttribute("result", 0);
                return "redirect:/member/login";	// 로그인 페이지로 이동

            }

        } else {					// 일치하는 아이디가 존재하지 않을 시 (로그인 실패)

            rttr.addFlashAttribute("result", 0);
            return "redirect:/member/login";	// 로그인 페이지로 이동

        }

    }

    /* 메인페이지 로그아웃 */
    @RequestMapping(value="logout.do", method=RequestMethod.GET)
    public String logoutMainGET(HttpServletRequest request) throws Exception{

        logger.info("logoutMainGET메서드 진입");

        HttpSession session = request.getSession();

        session.invalidate();
        return "redirect:/main";
    }
    /* 비동기방식 로그아웃 메서드 */
    @RequestMapping(value="logout.do", method=RequestMethod.POST)
    @ResponseBody
    public void logoutPOST(HttpServletRequest request) throws Exception{
        logger.info("비동기 로그아웃 메서드 진입");
        HttpSession session = request.getSession();
        session.invalidate();
    }
}