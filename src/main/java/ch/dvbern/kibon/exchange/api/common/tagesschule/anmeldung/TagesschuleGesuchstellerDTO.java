/*
 * Copyright (C) 2020 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common.tagesschule.anmeldung;

import java.time.LocalDate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.institution.AdresseDTO;
import ch.dvbern.kibon.exchange.api.common.shared.GesuchstellerDTO;

public class TagesschuleGesuchstellerDTO extends GesuchstellerDTO {

	private static final long serialVersionUID = 3493241283544795993L;

	@NotNull
	@Nonnull
	private Geschlecht geschlecht;

	@NotNull
	@Nonnull
	private LocalDate geburtsdatum;

	@Nullable
	private String mobile;

	@Nullable
	private String telefon;

	@Nullable
	private String telefonAusland;

	@Valid
	@NotNull
	@Nonnull
	private AdresseDTO adresse;

	public TagesschuleGesuchstellerDTO() {
		this.geschlecht = Geschlecht.WEIBLICH;
		this.geburtsdatum = LocalDate.MIN;
		this.mobile = null;
		this.telefon = null;
		this.telefonAusland = null;
		this.adresse = new AdresseDTO();
	}

	@Nonnull
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(@Nonnull Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	@Nonnull
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(@Nonnull LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Nullable
	public String getMobile() {
		return mobile;
	}

	public void setMobile(@Nullable String mobile) {
		this.mobile = mobile;
	}

	@Nullable
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(@Nullable String telefon) {
		this.telefon = telefon;
	}

	@Nullable
	public String getTelefonAusland() {
		return telefonAusland;
	}

	public void setTelefonAusland(@Nullable String telefonAusland) {
		this.telefonAusland = telefonAusland;
	}

	@Nonnull
	public AdresseDTO getAdresse() {
		return adresse;
	}

	public void setAdresse(@Nonnull AdresseDTO adresse) {
		this.adresse = adresse;
	}
}
