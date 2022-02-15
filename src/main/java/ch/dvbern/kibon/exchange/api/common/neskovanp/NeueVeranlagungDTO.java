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

package ch.dvbern.kibon.exchange.api.common.neskovanp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class NeueVeranlagungDTO implements Serializable {

	private static final long serialVersionUID = 4730581613392955915L;

	@Schema(description = "ZPV Nummer")
	@NotNull
	@Min(0)
	@Nonnull
	private Integer zpvNummer;

	@Schema(description = "Geburtsdatum")
	@Nonnull
	private @NotNull LocalDate geburtsdatum;

	@Schema(description = "KiBon Antrag ID")
	@Nonnull
	private @Size(min = 1) @NotNull String kibonAntragId;

	@Schema(description = "Gesuchsperiode Begin Jahr")
	@NotNull
	@Min(0)
	@Nonnull
	private Integer gesuchsperiodeBeginnJahr;

	public NeueVeranlagungDTO() {
		this.zpvNummer = 0;
		this.geburtsdatum = LocalDate.MIN;
		this.kibonAntragId = "";
		this.gesuchsperiodeBeginnJahr = 0;
	}

	public NeueVeranlagungDTO(
		@Nonnull Integer zpvNummer,
		@Nonnull LocalDate geburtsdatum,
		@Nonnull String kibonAntragId,
		@Nonnull Integer gesuchsperiodeBeginnJahr) {
		this.zpvNummer = zpvNummer;
		this.geburtsdatum = geburtsdatum;
		this.kibonAntragId = kibonAntragId;
		this.gesuchsperiodeBeginnJahr = gesuchsperiodeBeginnJahr;
	}

	@Nonnull
	public Integer getZpvNummer() {
		return zpvNummer;
	}

	public void setZpvNummer(@Nonnull Integer zpvNummer) {
		this.zpvNummer = zpvNummer;
	}

	@Nonnull
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(@Nonnull LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Nonnull
	public String getKibonAntragId() {
		return kibonAntragId;
	}

	public void setKibonAntragId(@Nonnull String kibonAntragId) {
		this.kibonAntragId = kibonAntragId;
	}

	@Nonnull
	public Integer getGesuchsperiodeBeginnJahr() {
		return gesuchsperiodeBeginnJahr;
	}

	public void setGesuchsperiodeBeginnJahr(@Nonnull Integer gesuchsperiodeBeginnJahr) {
		this.gesuchsperiodeBeginnJahr = gesuchsperiodeBeginnJahr;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", NeueVeranlagungDTO.class.getSimpleName() + '[', "]")
			.add("zpvNummer=" + zpvNummer)
			.add("geburtsdatum=" + geburtsdatum)
			.add("kibonAntragId='" + kibonAntragId)
			.add("gesuchsperiodeBeginnJahr=" + gesuchsperiodeBeginnJahr)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		NeueVeranlagungDTO that = (NeueVeranlagungDTO) o;

		return getZpvNummer().equals(that.getZpvNummer())
			&& getGeburtsdatum().equals(that.getGeburtsdatum())
			&& getKibonAntragId().equals(that.getKibonAntragId())
			&& getGesuchsperiodeBeginnJahr().equals(that.getGesuchsperiodeBeginnJahr());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getZpvNummer(), getGeburtsdatum(), getKibonAntragId(), getGesuchsperiodeBeginnJahr());
	}
}
