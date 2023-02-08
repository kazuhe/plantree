package x.plantree.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
   * NotFoundException を登録する
   * 
   * @param ex      NotFoundException
   * @param request クライアントからのリクエスト情報
   * @return クライアントへのレスポンス
   */
  @ExceptionHandler(value = { NotFoundException.class })
  protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex,
      WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    return this.handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND,
        request);
  }

  /**
   * BadRequestException を登録する
   * 
   * @param ex      BadRequestException
   * @param request クライアントからのリクエスト情報
   * @return クライアントへのレスポンス
   */
  @ExceptionHandler(value = { BadRequestException.class })
  protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex,
      WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    return this.handleExceptionInternal(ex, errorResponse, new HttpHeaders(),
        HttpStatus.BAD_REQUEST, request);
  }

}
