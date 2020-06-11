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

package ch.dvbern.kibon.exchange.api.common.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.institution.InstitutionDTO;
import ch.dvbern.kibon.exchange.api.common.platzbestaetigung.BetreuungZeitabschnittDTO;
import ch.dvbern.kibon.exchange.api.common.verfuegung.BetreuungsAngebot;

public class BetreuungDTO implements Serializable {

	private static final long serialVersionUID = -806547086175525904L;

	/**
	 * Older (maybe unused) fields of the DTO have been made Nullable for now.
	 * Can be removed, if not in use
	 */
	@Nullable
	private BetreuungsAngebot betreuungsArt;

	@Nullable
	private @Valid InstitutionDTO institution;

	@Nonnull
	private @Size(min = 1) @NotNull String referenznummer;

	private boolean ausserordentlicherBetreuungsaufwand;

	@Nullable
	private List<Long> gemeindeBfsNrs;

	@Nullable
	private List<String> gemeindeNamen;

	@Nonnull
	private List<BetreuungZeitabschnittDTO> zeitabschnitte;

	public BetreuungDTO() {
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.institution = new InstitutionDTO();
		this.referenznummer = "";
		ausserordentlicherBetreuungsaufwand = false;
		gemeindeBfsNrs = null;
		gemeindeNamen = null;
		zeitabschnitte = new ArrayList<>();
	}

	public BetreuungDTO(
		@Nullable BetreuungsAngebot betreuungsArt,
		@Nullable InstitutionDTO institution,
		@Nonnull String referenznummer,
		boolean ausserordentlicherBetreuungsaufwand,
		@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte,
		@Nullable List<Long> gemeindeBfsNrs,
		@Nullable List<String> gemeindeNamen) {
		this.betreuungsArt = betreuungsArt;
		this.institution = institution;
		this.referenznummer = referenznummer;
		this.ausserordentlicherBetreuungsaufwand = ausserordentlicherBetreuungsaufwand;
		this.gemeindeBfsNrs = gemeindeBfsNrs;
		this.gemeindeNamen = gemeindeNamen;
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

		BetreuungDTO that = (BetreuungDTO) o;

		return getBetreuungsArt() == that.getBetreuungsArt() &&
			Objects.equals(getInstitution(), that.getInstitution()) &&
			getReferenznummer().equals(that.getReferenznummer()) &&
			getZeitabschnitte().equals(that.getZeitabschnitte()) &&
			Objects.equals(getGemeindeBfsNrs(), that.getGemeindeBfsNrs()) &&
			Objects.equals(getGemeindeNamen(), that.getGemeindeNamen());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBetreuungsArt(), getInstitution());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungDTO.class.getSimpleName() + '[', "]")
			.add("betreuungsArt=" + betreuungsArt)
			.add("institution=" + institution)
			.add("referenzNummer=" + referenznummer)
			.add("ausserordentlicherBetreuungsaufwand=" + ausserordentlicherBetreuungsaufwand)
			.toString();
	}

	@Nullable
	public BetreuungsAngebot getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nullable BetreuungsAngebot betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}

	@Nullable
	public InstitutionDTO getInstitution() {
		return institution;
	}

	public void setInstitution(@Nullable InstitutionDTO institution) {
		this.institution = institution;
	}

	@Nonnull
	public String getReferenznummer() {
		return referenznummer;
	}

	public void setReferenznummer(@Nonnull String referenznummer) {
		this.referenznummer = referenznummer;
	}

	public boolean isAusserordentlicherBetreuungsaufwand() {
		return ausserordentlicherBetreuungsaufwand;
	}

	public void setAusserordentlicherBetreuungsaufwand(boolean ausserordentlicherBetreuungsaufwand) {
		this.ausserordentlicherBetreuungsaufwand = ausserordentlicherBetreuungsaufwand;
	}

	@Nullable
	public List<Long> getGemeindeBfsNrs() {
		return gemeindeBfsNrs;
	}

	public void setGemeindeBfsNrs(@Nullable List<Long> gemeindeBfsNrs) {
		this.gemeindeBfsNrs = gemeindeBfsNrs;
	}

	@Nullable
	public List<String> getGemeindeNamen() {
		return gemeindeNamen;
	}

	public void setGemeindeNamen(@Nullable List<String> gemeindeNamen) {
		this.gemeindeNamen = gemeindeNamen;
	}

	@Nonnull
	public List<BetreuungZeitabschnittDTO> getZeitabschnitte() {
		return zeitabschnitte;
	}

	public void setZeitabschnitte(@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte) {
		this.zeitabschnitte = zeitabschnitte;
	}
}
