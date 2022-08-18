/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
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
	private List<VerfuegungDTO> verfuegungen = new ArrayList();

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
