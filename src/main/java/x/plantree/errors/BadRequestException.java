package x.plantree.errors;

import org.springframework.http.HttpStatus;

/**
 * 無効なリクエストに対する例外
 */
public class BadRequestException extends HttpException {

  public BadRequestException() {
    super(HttpStatus.BAD_REQUEST);
  }

  public BadRequestException(String message) {
    super(message, HttpStatus.BAD_REQUEST);
  }

}
