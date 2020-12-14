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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class BetreuungStornierungAnfrageDTO implements Serializable {

	private static final long serialVersionUID = 4875118415422697381L;

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND.BETREUUNG")
	@Nonnull
	private @Size(min = 1) @NotNull String refnr;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionId;


	public BetreuungStornierungAnfrageDTO() {
		this.institutionId = "";
		this.refnr = "";
	}

	public BetreuungStornierungAnfrageDTO(
		@Nonnull String refNr,
		@Nonnull String institutionId
	) {
		this.refnr = refNr;
		this.institutionId = institutionId;
	}

	@Nonnull
	public String getRefnr() {
		return this.refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public String getInstitutionId() { return this.institutionId; }

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungStornierungAnfrageDTO adresse = (BetreuungStornierungAnfrageDTO) o;

		return getRefnr().equals(adresse.getRefnr()) &&
			getInstitutionId().equals(adresse.getInstitutionId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRefnr(), getInstitutionId());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungStornierungAnfrageDTO.class.getSimpleName() + '[', "]")
			.add("fallNummer='" + refnr + '\'')
			.add("institutionId='" + institutionId + '\'')
			.toString();
	}

}
