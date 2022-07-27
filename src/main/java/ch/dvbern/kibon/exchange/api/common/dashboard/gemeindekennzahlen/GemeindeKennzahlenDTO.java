/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.dvbern.kibon.exchange.api.common.dashboard.gemeindekennzahlen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.EinschulungTyp;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class GemeindeKennzahlenDTO implements Serializable {

	private static final long serialVersionUID = 7262604731097288786L;

	private static final Comparator<BigDecimal> BIG_DECIMAL_COMPARATOR =
		Comparator.nullsLast(Comparator.naturalOrder());

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long id;

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
		this.id = 0L;
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
		@Nonnull @NotNull Long id,
		@Nonnull @NotNull Long bfsNummer,
		@Nonnull @NotNull LocalDate gesuchsperiodeStart,
		@Nonnull @NotNull LocalDate gesuchsperiodeStop,
		@Nullable Boolean kontingentierung,
		@Nullable Boolean kontingentierungAusgeschoepft,
		@Nullable BigDecimal anzahlKinderWarteliste,
		@Nullable BigDecimal dauerWarteliste,
		@Nullable EinschulungTyp limitierungTfo,
		@Nullable EinschulungTyp limitierungKita, @Nullable BigDecimal erwerbspensumZuschlag) {
		this.id = id;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GemeindeKennzahlenDTO that = (GemeindeKennzahlenDTO) o;
		return getId().equals(that.getId())
			&& getBfsNummer().equals(that.getBfsNummer())
			&& getGesuchsperiodeStart().equals(that.getGesuchsperiodeStart())
			&& getGesuchsperiodeStop().equals(that.getGesuchsperiodeStop())
			&& Objects.equals(getKontingentierung(), that.getKontingentierung())
			&& Objects.equals(getKontingentierungAusgeschoepft(), that.getKontingentierungAusgeschoepft())
			&& BIG_DECIMAL_COMPARATOR.compare(getAnzahlKinderWarteliste(), that.getAnzahlKinderWarteliste()) == 0
			&& BIG_DECIMAL_COMPARATOR.compare(getDauerWarteliste(), that.getDauerWarteliste()) == 0
			&& getLimitierungTfo() == that.getLimitierungTfo()
			&& getLimitierungKita() == that.getLimitierungKita()
			&& BIG_DECIMAL_COMPARATOR.compare(getErwerbspensumZuschlag(), that.getErwerbspensumZuschlag()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getId(),
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
	public String toString() {
		return new StringJoiner(", ", GemeindeKennzahlenDTO.class.getSimpleName() + '[', "]")
			.add("id=" + id)
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
	public Long getId() {
		return id;
	}

	public void setId(@Nonnull Long id) {
		this.id = id;
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
