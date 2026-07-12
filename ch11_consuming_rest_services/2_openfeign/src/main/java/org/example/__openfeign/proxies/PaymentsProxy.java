package org.example.__openfeign.proxies;

/*
The first thing to do is annotate the interface with @FeignClient to tell OpenFeign it has to provide
an implementation for the interface.

Secondly, we must give the proxy a name to uniquely identify this specific client in the app using the
name attribute.

OpenFeign needs to know the address so it knows where to send the request, in which case we use the
url attribute.

Finally, OpenFeign needs to know where to find the interfaces defining client contracts hence we
use the @EnableFeignClients annotation on a config class to enable the OpenFeign functionality & tell
OpenFeign where to search for client contracts.

After that is complete, you can then inject the OpenFeign client into your controller class.
 */

import org.example.__openfeign.models.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${payment.service.url}")
public interface PaymentsProxy {
    @PostMapping("/payments")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}
