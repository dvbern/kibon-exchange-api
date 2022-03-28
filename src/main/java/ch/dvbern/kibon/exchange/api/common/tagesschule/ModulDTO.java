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

package ch.dvbern.kibon.exchange.api.common.tagesschule;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.tagesschule.anmeldung.Intervall;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ModulDTO implements Serializable {

	private static final long serialVersionUID = -2746396956558479190L;

	@Schema(description = "kiBon ID des Moduls")
	@NotNull
	@Size(min = 1)
	@Nonnull
	private String id;

	@Schema(description = "Benutzerdefinierte ID des ausgewählten Moduls")
	@Nullable
	private String fremdId;

	@Schema(description = "Deutsche Bezeichnung")
	@NotNull
	@Nonnull
	private String bezeichnungDE;

	@Schema(description = "Französische Bezeichnung")
	@NotNull
	@Nonnull
	private String bezeichnungFR;

	@Schema(description = "Modul Beginn")
	@NotNull
	@Nonnull
	private LocalTime zeitVon;

	@Schema(description = "Modul Ende")
	@NotNull
	@Nonnull
	private LocalTime zeitBis;

	@Schema(description = "Auflistung aller Wochentage, an welchen das Modul angeboten wird.")
	@NotNull
	@Size(min = 1)
	@Nonnull
	private List<DayOfWeek> wochentage;

	@Schema(description = "Ein Modul kann in mehreren Intervallen angeboten werden, z.B. wöchentlich oder alle zwei "
		+ "Wochen.")
	@NotNull
	@Size(min = 1)
	@Nonnull
	private List<Intervall> erlaubteIntervalle;

	@Schema(description = "`true`, falls in dem Modul pädagogische Betreuut stattfindet.")
	@NotNull
	@Nonnull
	private Boolean wirdPaedagogischBetreut;

	@Schema(description = "Verpflegungskosten in CHF")
	@NotNull
	@Min(0)
	@Nonnull
	private BigDecimal verpflegungsKosten;

	public ModulDTO() {
		this.id = "";
		this.fremdId = null;
		this.bezeichnungDE = "";
		this.bezeichnungFR = "";
		this.zeitVon = LocalTime.MIN;
		this.zeitBis = LocalTime.MAX;
		this.wochentage = new ArrayList<>();
		this.erlaubteIntervalle = new ArrayList<>();
		this.wirdPaedagogischBetreut = false;
		this.verpflegungsKosten = BigDecimal.ZERO;
	}

	public ModulDTO(
		@Nonnull String id,
		@Nullable String fremdId,
		@Nonnull String bezeichnungDE,
		@Nonnull String bezeichnungFR,
		@Nonnull LocalTime zeitVon,
		@Nonnull LocalTime zeitBis,
		@Nonnull List<DayOfWeek> wochentage,
		@Nonnull List<Intervall> erlaubteIntervalle,
		@Nonnull Boolean wirdPaedagogischBetreut,
		@Nonnull BigDecimal verpflegungsKosten) {
		this.id = id;
		this.fremdId = fremdId;
		this.bezeichnungDE = bezeichnungDE;
		this.bezeichnungFR = bezeichnungFR;
		this.zeitVon = zeitVon;
		this.zeitBis = zeitBis;
		this.wochentage = wochentage;
		this.erlaubteIntervalle = erlaubteIntervalle;
		this.wirdPaedagogischBetreut = wirdPaedagogischBetreut;
		this.verpflegungsKosten = verpflegungsKosten;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ModulDTO.class.getSimpleName() + '[', "]")
			.add("id='" + id + '\'')
			.add("fremdId='" + fremdId + '\'')
			.add("bezeichnungDE='" + bezeichnungDE + '\'')
			.add("bezeichnungFR='" + bezeichnungFR + '\'')
			.add("zeitVon=" + zeitVon)
			.add("zeitBis=" + zeitBis)
			.add("wochentage=" + wochentage)
			.add("erlaubteIntervalle=" + erlaubteIntervalle)
			.add("wirdPaedagogischBetreut=" + wirdPaedagogischBetreut)
			.add("verpflegungskosten=" + verpflegungsKosten)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof ModulDTO)) {
			return false;
		}

		ModulDTO modulDTO = (ModulDTO) o;

		return getId().equals(modulDTO.getId()) &&
			Objects.equals(getFremdId(), modulDTO.getFremdId()) &&
			getBezeichnungDE().equals(modulDTO.getBezeichnungDE()) &&
			getBezeichnungFR().equals(modulDTO.getBezeichnungFR()) &&
			getZeitVon().equals(modulDTO.getZeitVon()) &&
			getZeitBis().equals(modulDTO.getZeitBis()) &&
			Objects.equals(getWochentage(), modulDTO.getWochentage()) &&
			Objects.equals(getErlaubteIntervalle(), modulDTO.getErlaubteIntervalle()) &&
			Objects.equals(getWirdPaedagogischBetreut(), modulDTO.getWirdPaedagogischBetreut()) &&
			getVerpflegungsKosten().compareTo(modulDTO.getVerpflegungsKosten()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
			getFremdId(),
			getBezeichnungDE(),
			getBezeichnungFR(),
			getZeitVon(),
			getZeitBis(),
			getWochentage(),
			getErlaubteIntervalle(),
			getWirdPaedagogischBetreut(),
			getVerpflegungsKosten());
	}

	@Nonnull
	public String getId() {
		return id;
	}

	public void setId(@Nonnull String id) {
		this.id = id;
	}

	@Nullable
	public String getFremdId() {
		return fremdId;
	}

	public void setFremdId(@Nullable String fremdId) {
		this.fremdId = fremdId;
	}

	@Nonnull
	public String getBezeichnungDE() {
		return bezeichnungDE;
	}

	public void setBezeichnungDE(@Nonnull String bezeichnungDE) {
		this.bezeichnungDE = bezeichnungDE;
	}

	@Nonnull
	public String getBezeichnungFR() {
		return bezeichnungFR;
	}

	public void setBezeichnungFR(@Nonnull String bezeichnungFR) {
		this.bezeichnungFR = bezeichnungFR;
	}

	@Nonnull
	public LocalTime getZeitVon() {
		return zeitVon;
	}

	public void setZeitVon(@Nonnull LocalTime zeitVon) {
		this.zeitVon = zeitVon;
	}

	@Nonnull
	public LocalTime getZeitBis() {
		return zeitBis;
	}

	public void setZeitBis(@Nonnull LocalTime zeitBis) {
		this.zeitBis = zeitBis;
	}

	@Nonnull
	public List<DayOfWeek> getWochentage() {
		return wochentage;
	}

	public void setWochentage(@Nonnull List<DayOfWeek> wochentage) {
		this.wochentage = wochentage;
	}

	@Nonnull
	public List<Intervall> getErlaubteIntervalle() {
		return erlaubteIntervalle;
	}

	public void setErlaubteIntervalle(@Nonnull List<Intervall> erlaubteIntervalle) {
		this.erlaubteIntervalle = erlaubteIntervalle;
	}

	@Nonnull
	public Boolean getWirdPaedagogischBetreut() {
		return wirdPaedagogischBetreut;
	}

	public void setWirdPaedagogischBetreut(@Nonnull Boolean wirdPaedagogischBetreut) {
		this.wirdPaedagogischBetreut = wirdPaedagogischBetreut;
	}

	@Nonnull
	public BigDecimal getVerpflegungsKosten() {
		return verpflegungsKosten;
	}

	public void setVerpflegungsKosten(@Nonnull BigDecimal verpflegungsKosten) {
		this.verpflegungsKosten = verpflegungsKosten;
	}
}
