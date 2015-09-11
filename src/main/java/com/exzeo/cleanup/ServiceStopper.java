package com.exzeo.cleanup;

import com.exzeo.es.ClientProvider;
import com.google.inject.Inject;

/**
 * Created by dhruvr on 12/9/15.
 */
public class ServiceStopper {


    @Inject
    private ClientProvider clientProvider;


    public void stopServices(){
        clientProvider.closeClient();
    }
}
