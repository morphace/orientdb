package com.orientechnologies.orient.server.jwt.impl;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import com.orientechnologies.orient.core.metadata.security.jwt.OJwtHeader;
import com.orientechnologies.orient.core.metadata.security.jwt.OKeyProvider;

/**
 * Created by emrul on 28/09/2014.
 *
 * @author Emrul Islam <emrul@emrul.com> Copyright 2014 Emrul Islam
 */
public class DefaultJwtKeyProvider implements OKeyProvider {

  private SecretKeySpec secret_key;

  public DefaultJwtKeyProvider(byte[] secret) {
    secret_key = new SecretKeySpec(secret, "HmacSHA256");
  }

  @Override
  public Key getKey(OJwtHeader header) {
    return secret_key;
  }

  @Override
  public String[] getKeys() {
    return new String[] { "HmacSHA256" };
  }
}
