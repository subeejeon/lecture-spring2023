package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

/**
 * 모든 컨트롤러가 process 메소드를 구현하도록 하는 Interface
 */
public interface ControllerV3 {
    ModelView process(Map<String, String> paraMap);
}
