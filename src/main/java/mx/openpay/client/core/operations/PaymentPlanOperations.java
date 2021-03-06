package mx.openpay.client.core.operations;

import static mx.openpay.client.utils.OpenpayPathComponents.ID;
import static mx.openpay.client.utils.OpenpayPathComponents.MERCHANT_ID;
import static mx.openpay.client.utils.OpenpayPathComponents.PAYMETNS_PLANS;

import java.util.List;

import mx.openpay.client.PaymentPlan;
import mx.openpay.client.core.JsonServiceClient;
import mx.openpay.client.exceptions.OpenpayServiceException;
import mx.openpay.client.exceptions.ServiceUnavailableException;


public class PaymentPlanOperations extends ServiceOperations {

    public PaymentPlanOperations(JsonServiceClient client) {
        super(client);
    }

    private static final String PAYMETNS_PLANS_PATH = MERCHANT_ID + PAYMETNS_PLANS;

    private static final String GET_PAYMETNS_PLANS = PAYMETNS_PLANS_PATH + ID;

    public PaymentPlan create(final PaymentPlan plan) throws OpenpayServiceException, ServiceUnavailableException {
        String path = String.format(PAYMETNS_PLANS_PATH, this.getMerchantId());
        return this.getJsonClient().post(path, plan, PaymentPlan.class);
    };

    public PaymentPlan get(final String paymentPlanId) throws OpenpayServiceException, ServiceUnavailableException {
        String path = String.format(GET_PAYMETNS_PLANS, this.getMerchantId(), paymentPlanId);
        return this.getJsonClient().get(path, PaymentPlan.class);
    };

    public List<PaymentPlan> listAll() throws OpenpayServiceException, ServiceUnavailableException {
        String path = String.format(PAYMETNS_PLANS_PATH, this.getMerchantId());
        return this.getJsonClient().list(path, null, PaymentPlan.class);
    };

}
