/*
 * Copyright 2013 Opencard Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.openpay.client.core.requests.transactions;

import java.math.BigDecimal;

import mx.openpay.client.Card;
import mx.openpay.client.core.requests.RequestBuilder;
import mx.openpay.client.enums.ChargeMethods;

/**
 * Parameters to charge a credit or debit card.
 * @author elopez
 */
public class CreateCardChargeParams extends RequestBuilder {

    public CreateCardChargeParams() {
        this.with("method", ChargeMethods.CARD.name().toLowerCase());
    }

    /**
     * A new card to use only for this charge. Required if no card Id is given.
     */
    public CreateCardChargeParams card(final Card card) {
        return this.with("card", card);
    }

    /**
     * The ID of a card to use for this charge. Required if no new card is given.
     */
    public CreateCardChargeParams cardId(final String cardId) {
        return this.with("source_id", cardId);
    }

    /**
     * The amount to charge to the card, in MXN. Required.
     */
    public CreateCardChargeParams amount(final BigDecimal amount) {
        return this.with("amount", amount);
    }

    /**
     * A description to give to the charge. Optional.
     */
    public CreateCardChargeParams description(final String description) {
        return this.with("description", description);
    }

    /**
     * An unique custom identifier for the charge. Optional.
     */
    public CreateCardChargeParams orderId(final String orderId) {
        return this.with("order_id", orderId);
    }

    /**
     * If false, a preathorization will be made and the card won't be charged until the capture method is called.
     */
    public CreateCardChargeParams capture(final Boolean capture) {
        return this.with("capture", capture);
    }

}