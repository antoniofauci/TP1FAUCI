package comptoirs.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Projection {
    Integer getNumeroCommande();
    LocalDate getSaisiele();
    LocalDate getEnvoyeele();
    BigDecimal getPort();
    String gedtDestinatiare();
    BigDecimal getRemise();

}