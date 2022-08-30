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

package ch.dvbern.kibon.exchange.api.common.dashboard.institution;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.BetreuungsangebotTyp;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class InstitutionDTO implements Serializable {

	private static final long serialVersionUID = 2882496690468113564L;

	private static final Comparator<BigDecimal> BIG_DECIMAL_COMPARATOR =
		Comparator.nullsLast(Comparator.naturalOrder());

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long id;

	@Nonnull
	private @NotNull String institutionId;

	@Nonnull
	private @NotNull String name;

	@Nonnull
	private @NotNull BetreuungsangebotTyp betreuungsArt;

	@Nonnull
	private @NotNull LocalDate betreuungsgutscheineAb;

	@Nullable
	private LocalDate betreuungsgutscheineBis;

	@Nonnull
	private @NotNull @Valid AdresseInstitutionDTO adresse;

	@Nullable
	private BigDecimal anzahlPlaetze;

	@Nullable
	private BigDecimal anzahlPlaetzeFirmen;

	@Nullable
	private BigDecimal auslastungPct;

	public InstitutionDTO() {
		this.id = 0L;
		this.institutionId = "";
		this.name = "";
		this.betreuungsArt = BetreuungsangebotTyp.KITA;
		this.adresse = new AdresseInstitutionDTO();
		this.anzahlPlaetze = BigDecimal.ZERO;
		this.anzahlPlaetzeFirmen = BigDecimal.ZERO;
		this.auslastungPct = BigDecimal.ZERO;
		this.betreuungsgutscheineAb = LocalDate.MIN;
		this.betreuungsgutscheineBis = LocalDate.MAX;
	}

	public InstitutionDTO(
		@Nonnull Long id,
		@Nonnull String institutionId,
		@Nonnull String name,
		@Nonnull BetreuungsangebotTyp betreuungsArt,
		@Nonnull AdresseInstitutionDTO adresse,
		@Nullable BigDecimal anzahlPlaetze,
		@Nullable BigDecimal anzahlPlaetzeFirmen,
		@Nullable BigDecimal auslastungPct,
		@Nonnull LocalDate betreuungsgutscheineAb,
		@Nonnull LocalDate betreuungsgutscheineBis) {
		this.id = id;
		this.institutionId = institutionId;
		this.name = name;
		this.betreuungsArt = betreuungsArt;
		this.adresse = adresse;
		this.anzahlPlaetze = anzahlPlaetze;
		this.anzahlPlaetzeFirmen = anzahlPlaetzeFirmen;
		this.auslastungPct = auslastungPct;
		this.betreuungsgutscheineAb = betreuungsgutscheineAb;
		this.betreuungsgutscheineBis = betreuungsgutscheineBis;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass().equals(o.getClass())) {
			return false;
		}
		InstitutionDTO that = (InstitutionDTO) o;
		return getId().equals(that.getId())
			&& getInstitutionId().equals(that.getInstitutionId())
			&& getName().equals(that.getName())
			&& getBetreuungsArt() == that.getBetreuungsArt()
			&& getAdresse().equals(that.getAdresse())
			&& BIG_DECIMAL_COMPARATOR.compare(getAnzahlPlaetze(), that.getAnzahlPlaetze()) == 0
			&& BIG_DECIMAL_COMPARATOR.compare(getAnzahlPlaetzeFirmen(), that.getAnzahlPlaetzeFirmen()) == 0
			&& BIG_DECIMAL_COMPARATOR.compare(getAuslastungPct(), that.getAuslastungPct()) == 0
			&& getBetreuungsgutscheineAb().equals(that.getBetreuungsgutscheineAb())
			&& Objects.equals(getBetreuungsgutscheineBis(), that.getBetreuungsgutscheineBis());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
			getInstitutionId(),
			getName(),
			getBetreuungsArt(),
			getAdresse(),
			getAnzahlPlaetze(),
			getAnzahlPlaetzeFirmen(),
			getAuslastungPct(),
			getBetreuungsgutscheineAb(),
			getBetreuungsgutscheineBis());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", InstitutionDTO.class.getSimpleName() + '[', "]")
			.add("id=" + id)
			.add("institutionId=" + institutionId)
			.add("name=" + name)
			.add("betreuungsArt=" + betreuungsArt)
			.add("adresse=" + adresse)
			.add("anzahlPlaetze=" + anzahlPlaetze)
			.add("anzahlPlaetzeFirmen=" + anzahlPlaetzeFirmen)
			.add("auslastungPct=" + auslastungPct)
			.add("betreuungsgutscheineAb=" + betreuungsgutscheineAb)
			.add("betreuungsgutscheineBis=" + betreuungsgutscheineBis)
			.toString();
	}

	@Nonnull
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("zusatzId")
	public void setId(@Nonnull Long id) {
		this.id = id;
	}

	@Nonnull
	@JsonProperty("institutionId")
	public String getInstitutionId() {
		return institutionId;
	}

	@JsonProperty("id")
	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public String getName() {
		return name;
	}

	public void setName(@Nonnull String name) {
		this.name = name;
	}

	@Nonnull
	public BetreuungsangebotTyp getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nonnull BetreuungsangebotTyp betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}

	@Nonnull
	@JsonProperty("adresse")
	public AdresseInstitutionDTO getAdresse() {
		return adresse;
	}

	@JsonProperty("kontaktAdresse")
	public void setAdresse(@Nonnull AdresseInstitutionDTO adresse) {
		this.adresse = adresse;
	}

	@Nullable
	public BigDecimal getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	public void setAnzahlPlaetze(@Nullable BigDecimal anzahlPlaetze) {
		this.anzahlPlaetze = anzahlPlaetze;
	}

	@Nullable
	public BigDecimal getAnzahlPlaetzeFirmen() {
		return anzahlPlaetzeFirmen;
	}

	public void setAnzahlPlaetzeFirmen(@Nullable BigDecimal anzahlPlaetzeFirmen) {
		this.anzahlPlaetzeFirmen = anzahlPlaetzeFirmen;
	}

	@Nullable
	public BigDecimal getAuslastungPct() {
		return auslastungPct;
	}

	public void setAuslastungPct(@Nullable BigDecimal auslastungPct) {
		this.auslastungPct = auslastungPct;
	}

	@Nonnull
	@JsonProperty("betreuungsgutscheineAb")
	public LocalDate getBetreuungsgutscheineAb() {
		return betreuungsgutscheineAb;
	}

	@JsonProperty("betreuungsGutscheineAb")
	public void setBetreuungsgutscheineAb(@Nonnull LocalDate betreuungsgutscheineAb) {
		this.betreuungsgutscheineAb = betreuungsgutscheineAb;
	}

	@Nullable
	@JsonProperty("betreuungsgutscheineBis")
	public LocalDate getBetreuungsgutscheineBis() {
		return betreuungsgutscheineBis;
	}

	@JsonProperty("betreuungsGutscheineBis")
	public void setBetreuungsgutscheineBis(@Nullable LocalDate betreuungsgutscheineBis) {
		this.betreuungsgutscheineBis = betreuungsgutscheineBis;
	}
}
