/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.api.services;

import org.apache.ambari.api.resources.ResourceDefinition;
import org.apache.ambari.api.services.serializers.ResultSerializer;
import org.apache.ambari.server.controller.spi.PropertyId;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides information on the current request.
 */
public interface Request {

  /**
   * Enum of request types.
   */
  public enum Type {
    GET,
    PUT,
    POST,
    DELETE
  }

  /**
   * Obtain the resource definition which corresponds to the resource being operated on by the request.
   * The resource definition provides information about the resource type;
   *
   * @return the associated {@link ResourceDefinition}
   */
  public ResourceDefinition getResourceDefinition();

  /**
   * Obtain the URI of this request.
   *
   * @return the request uri
   */
  public URI getURI();

  /**
   * Obtain the http request type.  Type is one of {@link Type}.
   *
   * @return the http request type
   */
  public Type getRequestType();

  /**
   * Obtain the api version of the request.  The api version is specified in the request URI.
   *
   * @return the api version of the request
   */
  public int getAPIVersion();

  /**
   * Obtain the query predicates that were provided in the URL query string.
   *
   * @return a map of request predicates
   */
  public Map<String, String> getQueryPredicates();

  /**
   * Obtain the set of partial response fields which were provided in the query string of the request uri.
   *
   * @return a set of the provided partial response fields
   */
  public Set<String> getPartialResponseFields();

  /**
   * Obtain the result serializer for the request. The default serializer is of type JSON.
   *
   * @return the result serializer for the request
   */
  public ResultSerializer getResultSerializer();

  /**
   * Obtain the processor which processes the result returned from the request handler.
   * The post processor adds additional information such as href fields to the result.
   *
   * @return the result processor associated with the request
   */
  public ResultPostProcessor getResultPostProcessor();

  /**
   * Obtain the http headers associated with the request.
   *
   * @return the http headers
   */
  public Map<String, List<String>> getHttpHeaders();

  /**
   * Obtain the http body associated with the request.
   *
   * @return the http body
   */
  public String getHttpBody();

  /**
   * Obtain the properties which have been parsed from the http body.
   *
   * @return a map containing the properties contained in the http body
   */
  public Map<PropertyId, String> getHttpBodyProperties();

    //TODO: refactor persistence mechanism
  /**
   * Obtain the appropriate persistence manager.
   *
   * @return the appropriate persistence manager
   */
  public PersistenceManager getPersistenceManager();
}
