package com.fetch.receipt.rest ;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.receipt.beans.PointsResponse;
import com.fetch.receipt.beans.Receipt;
import com.fetch.receipt.beans.ReceiptResponse;
import com.fetch.receipt.utils.Util;

/**
 * 
 * Rest controller to handle all requests related receipts
 * @author Divya
 *
 */
@RestController
public class ReceiptRestController {
	
	private Map<String, Receipt>  receiptMap = new HashMap<String,Receipt>();
	 
	/**
	 * Process Receipt Post API will take receipt JSON as input and sends id back to the user.
	 * For testing used HashMap as storage. key as UUID and value as user receipt JSON input.
	 * @param receipt
	 * @return
	 */
	@RequestMapping(value = "/receipts/process", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptResponse processReceipt(@RequestBody Receipt receipt) {
		UUID uuid = UUID.randomUUID();
		receiptMap.put(uuid.toString(), receipt);
		ReceiptResponse res = new ReceiptResponse();
		res.setId(uuid.toString());
		return res;
    }
	
	/**
	 * Get api takes id as path param and applies Business rules based on receipt object saved. if exists.
	 * @param id
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/receipts/{id}/points", method = RequestMethod.GET)
    public PointsResponse getReceiptPoints(@PathVariable(required = true) String id ) throws ParseException {
		Receipt receipt = receiptMap.get(id);
		PointsResponse pr = new PointsResponse();
		long points = 0 ;
		if(receipt != null) {
			points = points + Util.getAlphaNumaricCount(receipt.getRetailer());
			points = points + Util.isTotalRounded(Double.parseDouble(receipt.getTotal()));
			points = points + Util.isTotalMultipleOfQuarter(Double.parseDouble(receipt.getTotal()));
			points = points + ((receipt.getItems().size() / 2 ) * 5) ;
			points = points + Util.getItemsDescPoints(receipt.getItems());
			points = points + Util.isPurchaseDateIdOdd(receipt.getPurchaseDate());
			points = points + Util.isPurchaseTimeBtw(receipt.getPurchaseTime());
			pr.setTotalPoints(String.valueOf(points));
		} else {
			pr.setTotalPoints("No Receipts Found with given id");
		}
		return pr;
    }
	
	
}
