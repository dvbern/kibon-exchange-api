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

package ch.dvbern.kibon.exchange.api.common.verfuegung;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.betreuung.BetreuungsAngebot;
import ch.dvbern.kibon.exchange.api.common.shared.GesuchstellerDTO;
import ch.dvbern.kibon.exchange.api.common.shared.KindDTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class VerfuegungDTO implements Serializable {

	private static final long serialVersionUID = 1339970917808014561L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long id;

	@Nonnull
	private @NotNull LocalDateTime availableSince;

	@Schema(description = "Eindeutige kiBon Referenz Nummmer\n\nSetzt sich zusammen aus JAHR.FALL.GEMEINDE.KIND.BETREUUNG")
	@Nonnull
	private @Size(min = 1) @NotNull String refnr;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionId;

	@Nonnull
	private @NotNull LocalDate von;

	@Nonnull
	private @NotNull LocalDate bis;

	@Schema(description = "Die Version der Verfügung. Wird eine Verfügung mutiert, steigt die Version. Eine höhere Version ersetzt eine niedrigere Version mit identischer \"refnr\"")
	@Nonnull
	private @NotNull Integer version;

	@Nonnull
	private @NotNull LocalDateTime verfuegtAm;

	@Nonnull
	private @NotNull BetreuungsAngebot betreuungsArt;

	@Nonnull
	private @NotNull Long gemeindeBfsNr;

	@Nonnull
	private @NotNull String gemeindeName;

	@Nonnull
	private @NotNull @Valid KindDTO kind;

	@Nonnull
	private @NotNull @Valid GesuchstellerDTO gesuchsteller;

	@Nonnull
	private @NotNull @Valid List<ZeitabschnittDTO> zeitabschnitte = new ArrayList<>();

	@Nonnull
	private @NotNull @Valid List<ZeitabschnittDTO> ignorierteZeitabschnitte = new ArrayList<>();

	public VerfuegungDTO() {
		this.id = -1L;
		this.availableSince = LocalDateTime.MIN;
		this.refnr = "";
		this.institutionId = "";
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MIN;
		this.version = -1;
		this.verfuegtAm = LocalDateTime.MIN;
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.gemeindeBfsNr = -1L;
		this.gemeindeName = "";
		this.kind = new KindDTO();
		this.gesuchsteller = new GesuchstellerDTO();
	}

	public VerfuegungDTO(
		@Nonnull Long id,
		@Nonnull LocalDateTime availableSince,
		@Nonnull String refnr,
		@Nonnull String institutionId,
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nonnull Integer version,
		@Nonnull LocalDateTime verfuegtAm,
		@Nonnull BetreuungsAngebot betreuungsArt,
		@Nonnull Long gemeindeBfsNr,
		@Nonnull String gemeindeName,
		@Nonnull KindDTO kind,
		@Nonnull GesuchstellerDTO gesuchsteller,
		@Nonnull List<ZeitabschnittDTO> zeitabschnitte,
		@Nonnull List<ZeitabschnittDTO> ignorierteZeitabschnitte) {
		this.id = id;
		this.availableSince = availableSince;
		this.refnr = refnr;
		this.institutionId = institutionId;
		this.von = von;
		this.bis = bis;
		this.version = version;
		this.verfuegtAm = verfuegtAm;
		this.betreuungsArt = betreuungsArt;
		this.gemeindeBfsNr = gemeindeBfsNr;
		this.gemeindeName = gemeindeName;
		this.kind = kind;
		this.gesuchsteller = gesuchsteller;
		this.zeitabschnitte = zeitabschnitte;
		this.ignorierteZeitabschnitte = ignorierteZeitabschnitte;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		VerfuegungDTO
			that = (VerfuegungDTO) o;

		return getId().equals(that.getId()) &&
			getRefnr().equals(that.getRefnr()) &&
			getInstitutionId().equals(that.getInstitutionId()) &&
			getVon().equals(that.getVon()) &&
			getBis().equals(that.getBis()) &&
			getVersion().equals(that.getVersion()) &&
			getVerfuegtAm().equals(that.getVerfuegtAm()) &&
			getBetreuungsArt() == that.getBetreuungsArt() &&
			getGemeindeBfsNr().equals(that.getGemeindeBfsNr()) &&
			getGemeindeName().equals(that.getGemeindeName()) &&
			getKind().equals(that.getKind()) &&
			getGesuchsteller().equals(that.getGesuchsteller()) &&
			getZeitabschnitte().equals(that.getZeitabschnitte()) &&
			getIgnorierteZeitabschnitte().equals(that.getIgnorierteZeitabschnitte());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
			getRefnr(),
			getInstitutionId(),
			getVon(),
			getBis(),
			getVersion(),
			getVerfuegtAm(),
			getBetreuungsArt(),
			getGemeindeBfsNr(),
			getGemeindeName(),
			getKind(),
			getGesuchsteller(),
			getZeitabschnitte(),
			getIgnorierteZeitabschnitte());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", VerfuegungDTO.class.getSimpleName() + '[', "]")
			.add("id='" + id + '\'')
			.add("refnr='" + refnr + '\'')
			.add("institutionId='" + institutionId + '\'')
			.add("von=" + von)
			.add("bis=" + bis)
			.add("version=" + version)
			.add("verfuegtAm=" + verfuegtAm)
			.add("bfsNummer=" + gemeindeBfsNr)
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
	public LocalDateTime getAvailableSince() {
		return availableSince;
	}

	public void setAvailableSince(@Nonnull LocalDateTime availableSince) {
		this.availableSince = availableSince;
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public LocalDate getVon() {
		return von;
	}

	public void setVon(@Nonnull LocalDate von) {
		this.von = von;
	}

	@Nonnull
	public LocalDate getBis() {
		return bis;
	}

	public void setBis(@Nonnull LocalDate bis) {
		this.bis = bis;
	}

	@Nonnull
	public Integer getVersion() {
		return version;
	}

	public void setVersion(@Nonnull Integer version) {
		this.version = version;
	}

	@Nonnull
	public LocalDateTime getVerfuegtAm() {
		return verfuegtAm;
	}

	public void setVerfuegtAm(@Nonnull LocalDateTime verfuegtAm) {
		this.verfuegtAm = verfuegtAm;
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
	public KindDTO getKind() {
		return kind;
	}

	public void setKind(@Nonnull KindDTO kind) {
		this.kind = kind;
	}

	@Nonnull
	public GesuchstellerDTO getGesuchsteller() {
		return gesuchsteller;
	}

	public void setGesuchsteller(@Nonnull GesuchstellerDTO gesuchsteller) {
		this.gesuchsteller = gesuchsteller;
	}

	@Nonnull
	public List<ZeitabschnittDTO> getZeitabschnitte() {
		return zeitabschnitte;
	}

	public void setZeitabschnitte(@Nonnull List<ZeitabschnittDTO> zeitabschnitte) {
		this.zeitabschnitte = zeitabschnitte;
	}

	@Nonnull
	public List<ZeitabschnittDTO> getIgnorierteZeitabschnitte() {
		return ignorierteZeitabschnitte;
	}

	public void setIgnorierteZeitabschnitte(@Nonnull List<ZeitabschnittDTO> ignorierteZeitabschnitte) {
		this.ignorierteZeitabschnitte = ignorierteZeitabschnitte;
	}
}
