/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
 *
 */

package com.netflix.spinnaker.halyard.deploy.spinnaker.v1;

import lombok.Data;

@Data
public class RunningServiceDetails {
  int running;
  int healthy;
  int enabled;
  String version;
  String artifactId;
  String internalEndpoint;
  String externalEndpoint;

  public RunningServiceDetails setService(SpinnakerEndpoints.Service service) {
    internalEndpoint = service.getBaseUrl();
    return this;
  }

  public RunningServiceDetails setService(SpinnakerEndpoints.PublicService service) {
    this.externalEndpoint = service.getPublicEndpoint();
    return setService((SpinnakerEndpoints.Service) service);
  }
}
