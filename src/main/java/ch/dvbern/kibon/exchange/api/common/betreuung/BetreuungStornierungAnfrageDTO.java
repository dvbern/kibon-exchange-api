/*
 * Copyright (C) 2020 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.betreuung;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BetreuungStornierungAnfrageDTO implements Serializable {

	private static final long serialVersionUID = 4875118415422697381L;

	@Nonnull
	private final String fallNummer;

	@Nonnull
	private final String institutionId;

	public BetreuungStornierungAnfrageDTO(
		@Nonnull String fallNummer,
		@Nonnull String institutionId
	) {
		this.fallNummer = fallNummer;
		this.institutionId = institutionId;
	}

	@Nonnull
	public String getFallNummer() {
		return this.fallNummer;
	}

	@Nonnull
	public String getInstitutionId() { return this.institutionId; }

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungStornierungAnfrageDTO adresse = (BetreuungStornierungAnfrageDTO) o;

		return getFallNummer().equals(adresse.getFallNummer()) &&
			getInstitutionId().equals(adresse.getInstitutionId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFallNummer(), getInstitutionId());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungStornierungAnfrageDTO.class.getSimpleName() + '[', "]")
			.add("fallNummer='" + fallNummer + '\'')
			.add("hausnummer='" + institutionId + '\'')
			.toString();
	}

}
