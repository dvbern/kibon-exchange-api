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
