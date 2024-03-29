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

package ch.dvbern.kibon.exchange.api.common.institution;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.shared.AdresseDTO;

public class InstitutionDTO implements Serializable {

	private static final long serialVersionUID = 5304104104672134122L;

	@Nonnull
	private @Size(min = 1) @NotNull String id;

	@Nonnull
	private @Size(min = 1) @NotNull String name;

	@Nullable
	private String traegerschaft = null;

	@Nonnull
	private @NotNull @Valid AdresseDTO adresse;

	@Nonnull
	private @NotNull @Valid KibonMandant mandant;

	public InstitutionDTO() {
		this.id = "";
		this.name = "";
		this.adresse = new AdresseDTO();
		this.mandant = KibonMandant.BERN;
	}

	public InstitutionDTO(
		@Nonnull String id,
		@Nonnull String name,
		@Nonnull String traegerschaft,
		@Nonnull AdresseDTO adresse,
		@Nonnull KibonMandant mandant) {
		this.id = id;
		this.name = name;
		this.traegerschaft = traegerschaft;
		this.adresse = adresse;
		this.mandant = mandant;
	}

		public InstitutionDTO(
		@Nonnull String id,
		@Nonnull String name,
		@Nonnull String traegerschaft,
		@Nonnull String strasse,
		@Nullable String hausnummer,
		@Nullable String adresszusatz,
		@Nonnull String plz,
		@Nonnull String ort,
		@Nonnull String land,
		@Nonnull KibonMandant mandant) {
		this.id = id;
		this.name = name;
		this.traegerschaft = traegerschaft;
		this.adresse = new AdresseDTO(strasse, hausnummer, adresszusatz, plz, ort, land);
		this.mandant = mandant;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		InstitutionDTO that = (InstitutionDTO) o;

		return getId().equals(that.getId()) &&
			getName().equals(that.getName()) &&
			Objects.equals(getTraegerschaft(), that.getTraegerschaft()) &&
			getAdresse().equals(that.getAdresse()) &&
			getMandant() == that.getMandant();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getTraegerschaft(), getAdresse(), getMandant());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", InstitutionDTO.class.getSimpleName() + '[', "]")
			.add("id='" + id + '\'')
			.add("name='" + name + '\'')
			.add("traegerschaft='" + traegerschaft + '\'')
			.add("mandant='" + mandant + '\'')
			.toString();
	}

	@Nonnull
	public String getId() {
		return id;
	}

	public void setId(@Nonnull String id) {
		this.id = id;
	}

	@Nonnull
	public String getName() {
		return name;
	}

	public void setName(@Nonnull String name) {
		this.name = name;
	}

	@Nullable
	public String getTraegerschaft() {
		return traegerschaft;
	}

	public void setTraegerschaft(@Nullable String traegerschaft) {
		this.traegerschaft = traegerschaft;
	}

	@Nonnull
	public AdresseDTO getAdresse() {
		return adresse;
	}

	public void setAdresse(@Nonnull AdresseDTO adresse) {
		this.adresse = adresse;
	}

	@Nonnull
	public KibonMandant getMandant() {
		return mandant;
	}

	public void setMandant(@Nonnull KibonMandant mandant) {
		this.mandant = mandant;
	}
}
