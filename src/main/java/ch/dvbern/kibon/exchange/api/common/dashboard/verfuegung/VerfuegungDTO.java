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
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class VerfuegungDTO implements Serializable {

	private static final long serialVersionUID = 8982964668846893686L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long sequenceId;

	@Nonnull
	private @NotNull String institutionId;

	@Nonnull
	private @NotNull LocalDateTime verfuegtAm;

	private boolean gueltig;

	@Nonnull
	private @NotNull String refnr;

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
		this.sequenceId = -1L;
		this.institutionId = "";
		this.verfuegtAm = LocalDateTime.MIN;
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.gemeindeBfsNr = -1L;
		this.gemeindeName = "";
		this.kind = new KindDTO();
		this.refnr = "";
		this.gueltig = true;
	}

	public VerfuegungDTO(
		@Nonnull Long sequenceId,
		@Nonnull String institutionId,
		@Nonnull LocalDateTime verfuegtAm,
		boolean gueltig,
		@Nonnull String refnr,
		@Nonnull BetreuungsAngebot betreuungsArt,
		@Nonnull Long gemeindeBfsNr,
		@Nonnull String gemeindeName,
		@Nonnull KindDTO kind,
		@Nonnull List<ZeitabschnittDTO> zeitabschnitte) {
		this.sequenceId = sequenceId;
		this.institutionId = institutionId;
		this.verfuegtAm = verfuegtAm;
		this.gueltig = gueltig;
		this.refnr = refnr;
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

		return getSequenceId().equals(that.getSequenceId()) &&
			getInstitutionId().equals(that.getInstitutionId()) &&
			getRefnr().equals(that.getRefnr()) &&
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
			getSequenceId(),
			getInstitutionId(),
			getRefnr(),
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
			.add("sequenceId=" + sequenceId)
			.add("institutionId=" + institutionId)
			.add("verfuegtAm=" + verfuegtAm)
			.add("gueltig=" + gueltig)
			.add("refnr=" + refnr)
			.add("betreuungsArt=" + betreuungsArt)
			.add("gemeindeBfsNr=" + gemeindeBfsNr)
			.add("gemeindeName=" + gemeindeName)
			.toString();
	}

	@Nonnull
	@JsonProperty("sequenceId")
	public Long getSequenceId() {
		return sequenceId;
	}

	@JsonProperty("id")
	public void setSequenceId(@Nonnull Long sequenceId) {
		this.sequenceId = sequenceId;
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
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public KindDTO getKind() {
		return kind;
	}

	public void setKind(@Nonnull KindDTO kind) {
		this.kind = kind;
	}
}
