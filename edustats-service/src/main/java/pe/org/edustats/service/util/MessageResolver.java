package pe.org.edustats.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;

@Component
public class MessageResolver {
  @Autowired
  private MessageSource messageSource;
  
  public String getMessage (String code, Object...arguments) {
    MessageSourceResolvable resolvable = new DefaultMessageSourceResolvable(new String[] { code }, arguments);
    return messageSource.getMessage(resolvable, LocaleContextHolder.getLocale());
  }

}
