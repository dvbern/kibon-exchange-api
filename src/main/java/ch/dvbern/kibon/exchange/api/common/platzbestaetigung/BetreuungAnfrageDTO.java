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
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.dvbern.kibon.exchange.api.common.shared.GesuchstellerDTO;
import ch.dvbern.kibon.exchange.api.common.shared.KindDTO;
import ch.dvbern.kibon.exchange.api.common.verfuegung.BetreuungsAngebot;

public class BetreuungAnfrageDTO implements Serializable {

	private static final long serialVersionUID = 6738640790684355946L;

	@Nonnull
	private @Size(min = 1) @NotNull String refnr;

	@Nonnull
	private @NotNull LocalDate periodeVon;

	@Nonnull
	private @NotNull LocalDate periodeBis;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionId;

	@Nonnull
	private @NotNull @Valid GesuchstellerDTO gesuchsteller;

	@Nonnull
	private @NotNull @Valid KindDTO kind;

	@Nonnull
	private @NotNull BetreuungsAngebot betreuungsArt;

	private boolean abgelehntVonGesuchsteller;

	public BetreuungAnfrageDTO() {
		this.refnr = "";
		this.periodeVon = LocalDate.MIN;
		this.periodeBis = LocalDate.MAX;
		this.institutionId = "";
		this.gesuchsteller = new GesuchstellerDTO();
		this.kind = new KindDTO();
		this.abgelehntVonGesuchsteller = false;
		this.betreuungsArt = BetreuungsAngebot.KITA;
	}

	public BetreuungAnfrageDTO(
		@Nonnull String refnr,
		@Nonnull LocalDate periodeVon,
		@Nonnull LocalDate periodeBis,
		@Nonnull String institutionId,
		@Nonnull GesuchstellerDTO gesuchsteller,
		@Nonnull KindDTO kind,
		@Nonnull BetreuungsAngebot betreuungsArt,
		boolean abgelehntVonGesuchsteller) {
		this.refnr = refnr;
		this.periodeVon = periodeVon;
		this.periodeBis = periodeBis;
		this.institutionId = institutionId;
		this.gesuchsteller = gesuchsteller;
		this.kind = kind;
		this.abgelehntVonGesuchsteller = abgelehntVonGesuchsteller;
		this.betreuungsArt = betreuungsArt;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungAnfrageDTO.class.getSimpleName() + '[', "]")
			.add("refnrbetreuung='" + refnr + '\'')
			.add("periodeVon=" + periodeVon)
			.add("periodeBis=" + periodeBis)
			.add("intitutionID=" + institutionId)
			.add("gesuchsteller=" + gesuchsteller.toString())
			.add("kind=" + kind.toString())
			.add("betreuungsArt=" + betreuungsArt.toString())
			.add("abgelehntVonGesuchsteller=" + abgelehntVonGesuchsteller)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungAnfrageDTO that = (BetreuungAnfrageDTO) o;

		return getRefnr().equals(that.getRefnr()) &&
			getBetreuungsArt() == that.getBetreuungsArt() &&
			getGesuchsteller().equals(that.getGesuchsteller()) &&
			getInstitutionId().equals(that.getInstitutionId()) &&
			getKind().equals(that.getKind()) &&
			getPeriodeVon().equals(that.getPeriodeVon()) &&
			getPeriodeBis().equals(that.getPeriodeBis());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getRefnr(),
			getBetreuungsArt(),
			getGesuchsteller(),
			getInstitutionId(),
			getKind(),
			getPeriodeVon(),
			getPeriodeBis());
	}

	@Nonnull
	public String getRefnr() {
		return refnr;
	}

	public void setRefnr(@Nonnull String refnr) {
		this.refnr = refnr;
	}

	@Nonnull
	public LocalDate getPeriodeVon() {
		return periodeVon;
	}

	public void setPeriodeVon(@Nonnull LocalDate periodeVon) {
		this.periodeVon = periodeVon;
	}

	@Nonnull
	public LocalDate getPeriodeBis() {
		return periodeBis;
	}

	public void setPeriodeBis(@Nonnull LocalDate periodeBis) {
		this.periodeBis = periodeBis;
	}

	@Nonnull
	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(@Nonnull String institutionId) {
		this.institutionId = institutionId;
	}

	@Nonnull
	public GesuchstellerDTO getGesuchsteller() {
		return gesuchsteller;
	}

	public void setGesuchsteller(@Nonnull GesuchstellerDTO gesuchsteller) {
		this.gesuchsteller = gesuchsteller;
	}

	@Nonnull
	public KindDTO getKind() {
		return kind;
	}

	public void setKind(@Nonnull KindDTO kind) {
		this.kind = kind;
	}

	public boolean isAbgelehntVonGesuchsteller() {
		return abgelehntVonGesuchsteller;
	}

	public void setAbgelehntVonGesuchsteller(boolean abgelehntVonGesuchsteller) {
		this.abgelehntVonGesuchsteller = abgelehntVonGesuchsteller;
	}

	@Nonnull
	public BetreuungsAngebot getBetreuungsArt() {
		return betreuungsArt;
	}

	public void setBetreuungsArt(@Nonnull BetreuungsAngebot betreuungsArt) {
		this.betreuungsArt = betreuungsArt;
	}
}
