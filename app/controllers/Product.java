package controllers;

import java.util.ArrayList;
import java.util.List;

import models.StockItem;

import org.apache.commons.lang.StringUtils;

import play.mvc.*;

import views.html.*;

@Catch
public class Product extends Controller {
 
  public static Result index() {
	  return redirect(routes.Product.list(1));
  }

  public static Result list(Long warehouseId) {
	List<StockItem> stockItems = StockItem.find.fetch("product").where().eq("warehouse.id", warehouseId).findList();
	if (stockItems.isEmpty()) {
		throw new RuntimeException("no results");
	}
	if (request().accepts("text/html")) {
		return ok(products.render(stockItems));
	}
	return ok(StringUtils.join(stockItems, "\n"));
  }
  
} 