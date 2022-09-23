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

package ch.dvbern.kibon.exchange.api.common.dashboard.verfuegung;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.betreuung.BetreuungsAngebot;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class VerfuegungDTO implements Serializable {

	private static final long serialVersionUID = 8982964668846893686L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long id;

	@Nonnull
	private @NotNull String institutionId;

	@Nonnull
	private @NotNull LocalDateTime verfuegtAm;

	private boolean gueltig;

	@Nonnull
	private @NotNull Integer fallNummer;

	@Nonnull
	private @NotNull BetreuungsAngebot betreuungsArt;

	@Nonnull
	private @NotNull Long gemeindeBfsNr;

	@Nonnull
	private @NotNull String gemeindeName;

	@Nonnull
	private @NotNull KindDTO kind;

	@Nonnull
	private @NotNull @Valid List<ZeitabschnittDTO> zeitabschnitte = new ArrayList<>();

	public VerfuegungDTO() {
		this.id = -1L;
		this.institutionId = "";
		this.verfuegtAm = LocalDateTime.MIN;
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.gemeindeBfsNr = -1L;
		this.gemeindeName = "";
		this.kind = new KindDTO();
		this.fallNummer = 0;
		this.gueltig = true;
	}

	public VerfuegungDTO(
		@Nonnull Long id,
		@Nonnull String institutionId,
		@Nonnull LocalDateTime verfuegtAm,
		boolean gueltig,
		@Nonnull Integer fallNummer,
		@Nonnull BetreuungsAngebot betreuungsArt,
		@Nonnull Long gemeindeBfsNr,
		@Nonnull String gemeindeName,
		@Nonnull KindDTO kind,
		@Nonnull List<ZeitabschnittDTO> zeitabschnitte) {
		this.id = id;
		this.institutionId = institutionId;
		this.verfuegtAm = verfuegtAm;
		this.gueltig = gueltig;
		this.fallNummer = fallNummer;
		this.betreuungsArt = betreuungsArt;
		this.gemeindeBfsNr = gemeindeBfsNr;
		this.gemeindeName = gemeindeName;
		this.kind = kind;
		this.zeitabschnitte = zeitabschnitte;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		VerfuegungDTO that = (VerfuegungDTO) o;

		return getId().equals(that.getId()) &&
			getInstitutionId().equals(that.getInstitutionId()) &&
			getFallNummer().equals(that.getFallNummer()) &&
			getVerfuegtAm().equals(that.getVerfuegtAm()) &&
			isGueltig() == that.isGueltig() &&
			getBetreuungsArt() == that.getBetreuungsArt() &&
			getGemeindeBfsNr().equals(that.getGemeindeBfsNr()) &&
			getGemeindeName().equals(that.getGemeindeName()) &&
			getKind().equals(that.getKind()) &&
			getZeitabschnitte().equals(that.getZeitabschnitte());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
			getInstitutionId(),
			getFallNummer(),
			isGueltig(),
			getVerfuegtAm(),
			getBetreuungsArt(),
			getGemeindeBfsNr(),
			getGemeindeName(),
			getKind(),
			getZeitabschnitte());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", VerfuegungDTO.class.getSimpleName() + '[', "]")
			.add("id=" + id)
			.add("institutionId=" + institutionId)
			.add("verfuegtAm=" + verfuegtAm)
			.add("gueltig=" + gueltig)
			.add("fallNummer=" + fallNummer)
			.add("betreuungsArt=" + betreuungsArt)
			.add("gemeindeBfsNr=" + gemeindeBfsNr)
			.add("gemeindeName=" + gemeindeName)
			.toString();
	}

	@Nonnull
	public Long getId() {
		return id;
	}

	public void setId(@Nonnull Long id) {
		this.id = id;
	}

	@Nonnull
	public LocalDateTime getVerfuegtAm() {
		return verfuegtAm;
	}

	public void setVerfuegtAm(@Nonnull LocalDateTime verfuegtAm) {
		this.verfuegtAm = verfuegtAm;
	}

	public boolean isGueltig() {
		return gueltig;
	}

	public void setGueltig(boolean gueltig) {
		this.gueltig = gueltig;
	}

	@Nonnull
	public BetreuungsAngebot getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nonnull BetreuungsAngebot betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}

	@Nonnull
	public Long getGemeindeBfsNr() {
		return gemeindeBfsNr;
	}

	public void setGemeindeBfsNr(@Nonnull Long gemeindeBfsNr) {
		this.gemeindeBfsNr = gemeindeBfsNr;
	}

	@Nonnull
	public String getGemeindeName() {
		return gemeindeName;
	}

	public void setGemeindeName(@Nonnull String gemeindeName) {
		this.gemeindeName = gemeindeName;
	}

	@Nonnull
	public List<ZeitabschnittDTO> getZeitabschnitte() {
		return zeitabschnitte;
	}

	public void setZeitabschnitte(@Nonnull List<ZeitabschnittDTO> zeitabschnitte) {
		this.zeitabschnitte = zeitabschnitte;
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public Integer getFallNummer() {
		return fallNummer;
	}

	public void setFallNummer(@Nonnull Integer fallNummer) {
		this.fallNummer = fallNummer;
	}

	@Nonnull
	public KindDTO getKind() {
		return kind;
	}

	public void setKind(@Nonnull KindDTO kind) {
		this.kind = kind;
	}
}
