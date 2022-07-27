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

package ch.dvbern.kibon.exchange.api.common.dashboard.institution;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.AdresseDTO;

public class AdresseInstitutionDTO extends AdresseDTO implements Serializable {

	private static final long serialVersionUID = 736599166980656860L;

	@Nonnull
	private @NotNull String standortGemeinde;

	@Nonnull
	private @NotNull String standortGemeindeBFSNummer;

	public AdresseInstitutionDTO() {
		this.standortGemeinde = "";
		this.standortGemeindeBFSNummer = "";
	}

	public AdresseInstitutionDTO(
		@Nonnull String strasse,
		@Nullable String hausnummer,
		@Nullable String adresszusatz,
		@Nonnull String plz,
		@Nonnull String ort,
		@Nonnull String land,
		@Nonnull @NotNull String standortGemeinde,
		@Nonnull @NotNull String standortGemeindeBFSNummer) {
		super(strasse, hausnummer, adresszusatz, plz, ort, land);
		this.standortGemeinde = standortGemeinde;
		this.standortGemeindeBFSNummer = standortGemeindeBFSNummer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		AdresseInstitutionDTO that = (AdresseInstitutionDTO) o;
		return getStandortGemeinde().equals(that.getStandortGemeinde())
			&& getStandortGemeindeBFSNummer().equals(that.getStandortGemeindeBFSNummer());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getStandortGemeinde(), getStandortGemeindeBFSNummer());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", AdresseInstitutionDTO.class.getSimpleName() + '[', "]")
			.add("standortGemeinde=" + standortGemeinde)
			.add("standortGemeindeBFSNummer=" + standortGemeindeBFSNummer)
			.toString();
	}

	@Nonnull
	public String getStandortGemeinde() {
		return standortGemeinde;
	}

	public void setStandortGemeinde(@Nonnull String standortGemeinde) {
		this.standortGemeinde = standortGemeinde;
	}

	@Nonnull
	public String getStandortGemeindeBFSNummer() {
		return standortGemeindeBFSNummer;
	}

	public void setStandortGemeindeBFSNummer(@Nonnull String standortGemeindeBFSNummer) {
		this.standortGemeindeBFSNummer = standortGemeindeBFSNummer;
	}
}
