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

package ch.dvbern.kibon.exchange.api.common.platzbestaetigung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BetreuungDTO implements Serializable {

	private static final long serialVersionUID = -806547086175525904L;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionId;

	@Nonnull
	private @Size(min = 1) @NotNull String refnr;

	@Nonnull
	private List<BetreuungZeitabschnittDTO> zeitabschnitte;

	@Nullable
	private Long gemeindeBfsNr;

	@Nullable
	private String gemeindeName;

	private boolean ausserordentlicherBetreuungsaufwand;

	public BetreuungDTO() {
		this.institutionId = "";
		this.refnr = "";
		zeitabschnitte = new ArrayList<>();
		gemeindeBfsNr = null;
		gemeindeName = null;
		ausserordentlicherBetreuungsaufwand = false;
	}

	public BetreuungDTO(
		@Nonnull String institutionId,
		@Nonnull String refnr,
		@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte,
		@Nullable Long gemeindeBfsNr,
		@Nullable String gemeindeName,
		boolean ausserordentlicherBetreuungsaufwand) {
		this.institutionId = institutionId;
		this.refnr = refnr;
		this.zeitabschnitte = zeitabschnitte;
		this.gemeindeBfsNr = gemeindeBfsNr;
		this.gemeindeName = gemeindeName;
		this.ausserordentlicherBetreuungsaufwand = ausserordentlicherBetreuungsaufwand;
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

		return Objects.equals(getInstitutionId(), that.getInstitutionId()) &&
			getRefnr().equals(that.getRefnr()) &&
			getZeitabschnitte().equals(that.getZeitabschnitte()) &&
			Objects.equals(getGemeindeBfsNr(), that.getGemeindeBfsNr()) &&
			Objects.equals(getGemeindeName(), that.getGemeindeName()) &&
			isAusserordentlicherBetreuungsaufwand() == that.isAusserordentlicherBetreuungsaufwand();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRefnr(), getZeitabschnitte(), getGemeindeBfsNr(), getGemeindeName(),
			getInstitutionId());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungDTO.class.getSimpleName() + '[', "]")
			.add("institutionId=" + getInstitutionId())
			.add("refnr=" + refnr)
			.add("zeitabschnitte=" + getZeitabschnitte().toString())
			.add("ausserordentlicherBetreuungsaufwand=" + ausserordentlicherBetreuungsaufwand)
			.toString();
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	public boolean isAusserordentlicherBetreuungsaufwand() {
		return ausserordentlicherBetreuungsaufwand;
	}

	public void setAusserordentlicherBetreuungsaufwand(boolean ausserordentlicherBetreuungsaufwand) {
		this.ausserordentlicherBetreuungsaufwand = ausserordentlicherBetreuungsaufwand;
	}

	@Nullable
	public Long getGemeindeBfsNr() {
		return gemeindeBfsNr;
	}

	public void setGemeindeBfsNr(@Nullable Long gemeindeBfsNr) {
		this.gemeindeBfsNr = gemeindeBfsNr;
	}

	@Nullable
	public String getGemeindeName() {
		return gemeindeName;
	}

	public void setGemeindeName(@Nullable String gemeindeName) {
		this.gemeindeName = gemeindeName;
	}

	@Nonnull
	public List<BetreuungZeitabschnittDTO> getZeitabschnitte() {
		return zeitabschnitte;
	}

	public void setZeitabschnitte(@Nonnull List<BetreuungZeitabschnittDTO> zeitabschnitte) {
		this.zeitabschnitte = zeitabschnitte;
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}
}
