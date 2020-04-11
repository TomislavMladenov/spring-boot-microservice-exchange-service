package com.openpayd.conversion.api;

import com.openpayd.conversion.model.Conversion;
import com.openpayd.conversion.service.ConversionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conversion")
@AllArgsConstructor
public class ConversionApi {

    private ConversionService conversionService;

    public enum Url {;
        public static final String getConversion = "/execute";
    }

    @RequestMapping(value = Url.getConversion, method = RequestMethod.GET)
    private ResponseEntity<Conversion> getConversion(
            @RequestParam(value = "sourceAmount") Float sourceAmount,
            @RequestParam(value = "sourceCurrency") String sourceCurrency,
            @RequestParam(value = "targetCurrency") String targetCurrency) {
       // return ResponseEntity.ok(conversionService.getConversion(sourceAmount, sourceCurrency, targetCurrency));
        return ResponseEntity.ok(null);
    }


}
