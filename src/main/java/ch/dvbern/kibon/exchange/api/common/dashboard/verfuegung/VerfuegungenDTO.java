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
package ch.dvbern.kibon.exchange.api.common.dashboard.verfuegung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class VerfuegungenDTO implements Serializable {

	private static final long serialVersionUID = -7245715037193066346L;

	@Nonnull
	@NotNull
	@Valid
	private List<VerfuegungDTO> verfuegungen = new ArrayList<>();

	public VerfuegungenDTO() {
	}

	@Nonnull
	public List<VerfuegungDTO> getVerfuegungen() {
		return verfuegungen;
	}

	public void setVerfuegungen(@Nonnull List<VerfuegungDTO> verfuegungen) {
		this.verfuegungen = verfuegungen;
	}
}
