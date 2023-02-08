package x.plantree.errors;

import org.springframework.http.HttpStatus;

/**
 * HTTP リクエストに対する例外
 */
public class HttpException extends RuntimeException {

  private final HttpStatus httpStatus;

  public HttpException(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public HttpException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  /**
   * HTTP ステータスを取得する
   * 
   * @return HTTP ステータス
   */
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
