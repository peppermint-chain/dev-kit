package com.peppermintchain.core.services;

import java.util.Map;

/**
 * This exception is throw if there is no consensus.
 * 
 * @author pramod
 *
 */
public class PMCConsensusException extends Exception {
    public static final String EXCEPTION_THROWN = "EXCEPTION_THROWN";

    private Map<String, String> consensusMap = null;

    public PMCConsensusException(Map<String, String> consensusMap) {
	this.consensusMap = consensusMap;
    }

    @Override
    public String getMessage() {
	return "Nodes Did not Reach a Consensus " + consensusMap;
    }

}
