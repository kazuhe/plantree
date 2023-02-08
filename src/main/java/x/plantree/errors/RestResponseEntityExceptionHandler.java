package x.plantree.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Spring Boot に対してエラーハンドラーを登録する
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * NotFoundException と BadRequestException を登録する
   * 
   * @param ex      HttpException
   * @param request クライアントからのリクエスト情報
   * @return クライアントへのレスポンス
   */
  @ExceptionHandler(value = { NotFoundException.class, BadRequestException.class })
  protected ResponseEntity<Object> handleHttpException(HttpException ex, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getHttpStatus());
    return this.handleExceptionInternal(ex, errorResponse, new HttpHeaders(), ex.getHttpStatus(),
        request);
  }

}
