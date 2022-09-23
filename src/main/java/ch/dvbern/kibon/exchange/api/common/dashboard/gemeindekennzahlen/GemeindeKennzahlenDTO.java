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

package ch.dvbern.kibon.exchange.api.common.dashboard.gemeindekennzahlen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.EinschulungTyp;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static ch.dvbern.kibon.exchange.api.common.util.ComparatorUtil.comparesEqual;

public class GemeindeKennzahlenDTO implements Serializable {

	private static final long serialVersionUID = 7262604731097288786L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long sequenceId;

	@Nonnull
	private @NotNull Long bfsNummer;

	@Nonnull
	private @NotNull LocalDate gesuchsperiodeStart;

	@Nonnull
	private @NotNull LocalDate gesuchsperiodeStop;

	@Nullable
	private Boolean kontingentierung;

	@Nullable
	private Boolean kontingentierungAusgeschoepft;

	@Nullable
	private BigDecimal anzahlKinderWarteliste;

	@Nullable
	private BigDecimal dauerWarteliste;

	@Nullable
	private EinschulungTyp limitierungTfo;

	@Nullable
	private EinschulungTyp limitierungKita;

	@Nullable
	private BigDecimal erwerbspensumZuschlag;

	public GemeindeKennzahlenDTO() {
		this.sequenceId = 0L;
		this.bfsNummer = 0L;
		this.gesuchsperiodeStart = LocalDate.MIN;
		this.gesuchsperiodeStop = LocalDate.MAX;
		this.kontingentierung = Boolean.TRUE;
		this.kontingentierungAusgeschoepft = Boolean.TRUE;
		this.anzahlKinderWarteliste = BigDecimal.ZERO;
		this.dauerWarteliste = BigDecimal.ZERO;
		this.limitierungTfo = EinschulungTyp.VORSCHULALTER;
		this.limitierungKita = EinschulungTyp.VORSCHULALTER;
		this.erwerbspensumZuschlag = BigDecimal.ZERO;
	}

	public GemeindeKennzahlenDTO(
		@Nonnull Long sequenceId,
		@Nonnull Long bfsNummer,
		@Nonnull LocalDate gesuchsperiodeStart,
		@Nonnull LocalDate gesuchsperiodeStop,
		@Nullable Boolean kontingentierung,
		@Nullable Boolean kontingentierungAusgeschoepft,
		@Nullable BigDecimal anzahlKinderWarteliste,
		@Nullable BigDecimal dauerWarteliste,
		@Nullable EinschulungTyp limitierungTfo,
		@Nullable EinschulungTyp limitierungKita,
		@Nullable BigDecimal erwerbspensumZuschlag) {
		this.sequenceId = sequenceId;
		this.bfsNummer = bfsNummer;
		this.gesuchsperiodeStart = gesuchsperiodeStart;
		this.gesuchsperiodeStop = gesuchsperiodeStop;
		this.kontingentierung = kontingentierung;
		this.kontingentierungAusgeschoepft = kontingentierungAusgeschoepft;
		this.anzahlKinderWarteliste = anzahlKinderWarteliste;
		this.dauerWarteliste = dauerWarteliste;
		this.limitierungTfo = limitierungTfo;
		this.limitierungKita = limitierungKita;
		this.erwerbspensumZuschlag = erwerbspensumZuschlag;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		GemeindeKennzahlenDTO that = (GemeindeKennzahlenDTO) o;

		return getSequenceId().equals(that.getSequenceId())
			&& getBfsNummer().equals(that.getBfsNummer())
			&& getGesuchsperiodeStart().equals(that.getGesuchsperiodeStart())
			&& getGesuchsperiodeStop().equals(that.getGesuchsperiodeStop())
			&& Objects.equals(getKontingentierung(), that.getKontingentierung())
			&& Objects.equals(getKontingentierungAusgeschoepft(), that.getKontingentierungAusgeschoepft())
			&& comparesEqual(getAnzahlKinderWarteliste(), that.getAnzahlKinderWarteliste())
			&& comparesEqual(getDauerWarteliste(), that.getDauerWarteliste())
			&& getLimitierungTfo() == that.getLimitierungTfo()
			&& getLimitierungKita() == that.getLimitierungKita()
			&& comparesEqual(getErwerbspensumZuschlag(), that.getErwerbspensumZuschlag());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getSequenceId(),
			getBfsNummer(),
			getGesuchsperiodeStart(),
			getGesuchsperiodeStop(),
			getKontingentierung(),
			getKontingentierungAusgeschoepft(),
			getAnzahlKinderWarteliste(),
			getDauerWarteliste(),
			getLimitierungTfo(),
			getLimitierungKita(),
			getErwerbspensumZuschlag());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", GemeindeKennzahlenDTO.class.getSimpleName() + '[', "]")
			.add("sequenceId=" + sequenceId)
			.add("bfsNummer=" + bfsNummer)
			.add("gesuchsperiodeStart=" + gesuchsperiodeStart)
			.add("gesuchsperiodeStop=" + gesuchsperiodeStop)
			.add("kontingentierung=" + kontingentierung)
			.add("kontingentierungAusgeschoepft=" + kontingentierungAusgeschoepft)
			.add("anzahlKinderWarteliste=" + anzahlKinderWarteliste)
			.add("dauerWarteliste=" + dauerWarteliste)
			.add("limitierungTfo=" + limitierungTfo)
			.add("limitierungKita=" + limitierungKita)
			.add("erwerbspensumZuschlag=" + erwerbspensumZuschlag)
			.toString();
	}

	@Nonnull
	public Long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(@Nonnull Long sequenceId) {
		this.sequenceId = sequenceId;
	}

	@Nonnull
	public Long getBfsNummer() {
		return bfsNummer;
	}

	public void setBfsNummer(@Nonnull Long bfsNummer) {
		this.bfsNummer = bfsNummer;
	}

	@Nonnull
	public LocalDate getGesuchsperiodeStart() {
		return gesuchsperiodeStart;
	}

	public void setGesuchsperiodeStart(@Nonnull LocalDate gesuchsperiodeStart) {
		this.gesuchsperiodeStart = gesuchsperiodeStart;
	}

	@Nonnull
	public LocalDate getGesuchsperiodeStop() {
		return gesuchsperiodeStop;
	}

	public void setGesuchsperiodeStop(@Nonnull LocalDate gesuchsperiodeStop) {
		this.gesuchsperiodeStop = gesuchsperiodeStop;
	}

	@Nullable
	public Boolean getKontingentierung() {
		return kontingentierung;
	}

	public void setKontingentierung(@Nullable Boolean kontingentierung) {
		this.kontingentierung = kontingentierung;
	}

	@Nullable
	public Boolean getKontingentierungAusgeschoepft() {
		return kontingentierungAusgeschoepft;
	}

	public void setKontingentierungAusgeschoepft(@Nullable Boolean kontingentierungAusgeschoepft) {
		this.kontingentierungAusgeschoepft = kontingentierungAusgeschoepft;
	}

	@Nullable
	public BigDecimal getAnzahlKinderWarteliste() {
		return anzahlKinderWarteliste;
	}

	public void setAnzahlKinderWarteliste(@Nullable BigDecimal anzahlKinderWarteliste) {
		this.anzahlKinderWarteliste = anzahlKinderWarteliste;
	}

	@Nullable
	public BigDecimal getDauerWarteliste() {
		return dauerWarteliste;
	}

	public void setDauerWarteliste(@Nullable BigDecimal dauerWarteliste) {
		this.dauerWarteliste = dauerWarteliste;
	}

	@Nullable
	public EinschulungTyp getLimitierungTfo() {
		return limitierungTfo;
	}

	public void setLimitierungTfo(@Nullable EinschulungTyp limitierungTfo) {
		this.limitierungTfo = limitierungTfo;
	}

	@Nullable
	public EinschulungTyp getLimitierungKita() {
		return limitierungKita;
	}

	public void setLimitierungKita(@Nullable EinschulungTyp limitierungKita) {
		this.limitierungKita = limitierungKita;
	}

	@Nullable
	public BigDecimal getErwerbspensumZuschlag() {
		return erwerbspensumZuschlag;
	}

	public void setErwerbspensumZuschlag(@Nullable BigDecimal erwerbspensumZuschlag) {
		this.erwerbspensumZuschlag = erwerbspensumZuschlag;
	}
}
