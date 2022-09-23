/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.dashboard.lastenausgleich;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class LastenausgleicheDTO implements Serializable {

	private static final long serialVersionUID = 7184687661321227218L;

	@Nonnull
	@NotNull
	@Valid
	private List<LastenausgleichDTO> lastenausgleiche = new ArrayList<>();

	public LastenausgleicheDTO() {
	}

	@Nonnull
	public List<LastenausgleichDTO> getLastenausgleiche() {
		return lastenausgleiche;
	}

	public void setLastenausgleiche(@Nonnull List<LastenausgleichDTO> lastenausgleiche) {
		this.lastenausgleiche = lastenausgleiche;
	}
}
