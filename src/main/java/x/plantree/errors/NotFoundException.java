package x.plantree.errors;

import org.springframework.http.HttpStatus;

/**
 * リソースが発見できないリクエストに対する例外
 */
public class NotFoundException extends HttpException {

  public NotFoundException() {
    super(HttpStatus.NOT_FOUND);
  }

  public NotFoundException(String message) {
    super(message, HttpStatus.NOT_FOUND);
  }

}
