/*
 * Copyright (C) 2019 DV Bern AG, Switzerland
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

package ch.dvbern.kibon.exchange.api.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.model.BetreuungsAngebot;

public class BetreuungDTO implements Serializable {

	private static final long serialVersionUID = -806547086175525904L;

	@Nonnull
	private @NotNull BetreuungsAngebot betreuungsArt;

	@Nonnull
	private @NotNull @Valid InstitutionDTO institution;

	@Nonnull
	private String referenznummer;

	private boolean ausserordentlicherBetreuungsaufwand;

	private boolean betreuungErfolgtInGemeinde;

	@Nonnull
	private List<BetreuungZeitabschnittDTO> zeitabschnitte;

	public BetreuungDTO() {
		this.betreuungsArt = BetreuungsAngebot.KITA;
		this.institution = new InstitutionDTO();
		this.referenznummer = "";
		ausserordentlicherBetreuungsaufwand = false;
		betreuungErfolgtInGemeinde = false;
		zeitabschnitte = new ArrayList<>();
	}

	public BetreuungDTO(@Nonnull BetreuungsAngebot betreuungsArt,
		@Nonnull InstitutionDTO institution,
		@Nonnull String referenznummer,
		boolean ausserordentlicherBetreuungsaufwand,
		boolean betreuungErfolgtInGemeinde,
		@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte) {
		this.betreuungsArt = betreuungsArt;
		this.institution = institution;
		this.referenznummer = referenznummer;
		this.ausserordentlicherBetreuungsaufwand = ausserordentlicherBetreuungsaufwand;
		this.betreuungErfolgtInGemeinde = betreuungErfolgtInGemeinde;
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

		BetreuungDTO betreuung = (BetreuungDTO) o;

		return getBetreuungsArt() == betreuung.getBetreuungsArt() &&
			getInstitution().equals(betreuung.getInstitution());
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
			.add("betreuungErfolgtInGemeinde=" + betreuungErfolgtInGemeinde)
			.toString();
	}

	@Nonnull
	public BetreuungsAngebot getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nonnull BetreuungsAngebot betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}

	@Nonnull
	public InstitutionDTO getInstitution() {
		return institution;
	}

	public void setInstitution(@Nonnull InstitutionDTO institution) {
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

	public boolean isBetreuungErfolgtInGemeinde() {
		return betreuungErfolgtInGemeinde;
	}

	public void setBetreuungErfolgtInGemeinde(boolean betreuungErfolgtInGemeinde) {
		this.betreuungErfolgtInGemeinde = betreuungErfolgtInGemeinde;
	}

	@Nonnull
	public List<BetreuungZeitabschnittDTO> getZeitabschnitte() {
		return zeitabschnitte;
	}

	public void setZeitabschnitte(@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte) {
		this.zeitabschnitte = zeitabschnitte;
	}
}
