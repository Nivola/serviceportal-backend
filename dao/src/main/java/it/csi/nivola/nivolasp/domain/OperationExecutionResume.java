/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.domain;

import java.io.Serializable;

public class OperationExecutionResume implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private Boolean success;
    private String message;

    public static OperationExecutionResume success() {
    	OperationExecutionResume o = new OperationExecutionResume();
    	o.setSuccess(true);
    	o.setMessage("success");
    	o.setCode("1");
    	return o;
    }

    public static OperationExecutionResume fail() {
    	OperationExecutionResume o = new OperationExecutionResume();
    	o.setSuccess(false);
    	o.setMessage("failed");
    	o.setCode("0");
    	return o;
    }

    public static OperationExecutionResume fail(String message) {
    	if (message == null) message = "failed";
    	OperationExecutionResume o = new OperationExecutionResume();
    	o.setSuccess(false);
    	o.setMessage(message);
    	o.setCode("0");
    	return o;
    }

    public static OperationExecutionResume fail(String code, String message) {
    	if (message == null) message = "failed";
    	OperationExecutionResume o = new OperationExecutionResume();
    	o.setSuccess(false);
    	o.setMessage(message);
    	o.setCode(code);
    	return o;
    }
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
