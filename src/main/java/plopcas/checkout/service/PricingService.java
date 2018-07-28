package plopcas.checkout.service;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.lang3.StringUtils;
import plopcas.checkout.exception.PricingRulesNotValidException;
import plopcas.checkout.model.Discount;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class PricingService {

  private static final String CSV_SPLIT_BY = ",";

  private File pricingRulesFile;

  public PricingService(File pricingRulesFile) {
    this.pricingRulesFile = pricingRulesFile;
  }

  public PricingRules getPricingRules() {

    PricingRules pricingRules = new PricingRules();

    String line = StringUtils.EMPTY;

    try (BufferedReader br = new BufferedReader(new FileReader(pricingRulesFile))) {
      
      // Skip header
      br.readLine();

      while ((line = br.readLine()) != null) {

        String[] itemTokens = line.split(CSV_SPLIT_BY);

        Discount discount = getDiscount(itemTokens);
        Item item = new Item(itemTokens[0], parseInt(itemTokens[1]), discount);

        pricingRules.put(itemTokens[0], item);
      }

    } catch (Exception e) {
      throw new PricingRulesNotValidException(
          String.format("Error loading pricing rules: %s", e.getMessage()));
    }

    return pricingRules;
  }

  private Discount getDiscount(String[] itemTokens) {
    Discount discount = null;

    if (itemTokens.length == 4 && isNotBlank(itemTokens[2]) && isNotBlank(itemTokens[3])) {
      discount = new Discount(parseInt(itemTokens[2]), parseInt(itemTokens[3]));
    }

    return discount;
  }

}
