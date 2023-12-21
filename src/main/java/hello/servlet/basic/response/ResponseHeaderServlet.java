package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK); //응답 코드

        //[response-header]
        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        //[HTTP 편의 메서드]
//        content(resp);
        cookie(resp);
//        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    //[컨텐츠 생성]
    private void content(HttpServletResponse resp) {
        resp.setContentType("test/plain");
        resp.setCharacterEncoding("utf-8");
    }

    //[쿠키 생성]
    private void cookie(HttpServletResponse resp) {
       // Set-Cookie : myCookie=good ; Max-Age = 600; URL로 쿠키 생성
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);  //600초동안 유효
        resp.addCookie(cookie);
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //Status Code: 302
        //Location : /basic/hello-form.html
        resp.sendRedirect("/basic/hello-form.html");
    }

}
