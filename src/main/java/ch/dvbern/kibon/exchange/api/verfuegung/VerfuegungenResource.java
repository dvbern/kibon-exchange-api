/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.dvbern.kibon.exchange.api.verfuegung;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ch.dvbern.kibon.exchange.api.verfuegung.model.ws.VerfuegungenDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/verfuegungen")
@RegisterRestClient
public interface VerfuegungenResource {

	@GET
	@Nonnull
	VerfuegungenDTO getAll(
		@QueryParam("after_id") @Nullable Long afterId,
		@Min(0) @QueryParam("limit") @Nullable Integer limit,
		@QueryParam("$filter") @Nullable String filter
	);
}
