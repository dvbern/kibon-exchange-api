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

package ch.dvbern.kibon.exchange.api.verfuegung.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ZeitabschnittDTO implements Serializable, Zeitabschnitt {

	private static final long serialVersionUID = -4604369503819718952L;

	private static final Comparator<BigDecimal> BIG_DECIMAL_COMPARATOR =
		Comparator.nullsLast(Comparator.naturalOrder());

	@Nonnull
	private @NotNull LocalDate von;

	@Nonnull
	private @NotNull LocalDate bis;

	@Nullable
	private @Min(0) Integer verfuegungNr;

	@Nonnull
	private @NotNull @DecimalMin("0") @DecimalMax("100") BigDecimal effektiveBetreuungPct;

	@Nonnull
	private @NotNull @Min(0) @Max(100) Integer anspruchPct;

	@Nonnull
	private @NotNull @DecimalMin("0") @DecimalMax("100") BigDecimal verguenstigtPct;

	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal vollkosten;

	@Nullable
	private @DecimalMin("0") BigDecimal betreuungsgutschein;

	@Nullable
	private @DecimalMin("0") BigDecimal minimalerElternbeitrag;

	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal verguenstigung;

	@Nullable
	private @DecimalMin("0") BigDecimal verfuegteAnzahlZeiteinheiten;

	@Nullable
	private @DecimalMin("0") BigDecimal anspruchsberechtigteAnzahlZeiteinheiten;

	@Nullable
	private Zeiteinheit zeiteinheit;

	public ZeitabschnittDTO() {
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MIN;
		this.effektiveBetreuungPct = BigDecimal.ZERO;
		this.anspruchPct = -1;
		this.verguenstigtPct = BigDecimal.ZERO;
		this.vollkosten = BigDecimal.ZERO;
		this.verguenstigung = BigDecimal.ZERO;
	}

	public ZeitabschnittDTO(
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nullable Integer verfuegungNr,
		@Nonnull BigDecimal effektiveBetreuungPct,
		@Nonnull Integer anspruchPct,
		@Nonnull BigDecimal verguenstigtPct,
		@Nonnull BigDecimal vollkosten,
		@Nullable BigDecimal betreuungsgutschein,
		@Nullable BigDecimal minimalerElternbeitrag,
		@Nonnull BigDecimal verguenstigung) {
		this.von = von;
		this.bis = bis;
		this.verfuegungNr = verfuegungNr;
		this.effektiveBetreuungPct = effektiveBetreuungPct;
		this.anspruchPct = anspruchPct;
		this.verguenstigtPct = verguenstigtPct;
		this.vollkosten = vollkosten;
		this.betreuungsgutschein = betreuungsgutschein;
		this.minimalerElternbeitrag = minimalerElternbeitrag;
		this.verguenstigung = verguenstigung;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		ZeitabschnittDTO that = (ZeitabschnittDTO) o;

		return getVon().equals(that.getVon()) &&
			getBis().equals(that.getBis()) &&
			Objects.equals(getVerfuegungNr(), that.getVerfuegungNr()) &&
			getEffektiveBetreuungPct().compareTo(that.getEffektiveBetreuungPct()) == 0 &&
			getAnspruchPct().equals(that.getAnspruchPct()) &&
			getVerguenstigtPct().compareTo(that.getVerguenstigtPct()) == 0 &&
			getVollkosten().compareTo(that.getVollkosten()) == 0 &&
			BIG_DECIMAL_COMPARATOR.compare(getBetreuungsgutschein(), that.getBetreuungsgutschein()) == 0 &&
			BIG_DECIMAL_COMPARATOR.compare(getMinimalerElternbeitrag(), that.getMinimalerElternbeitrag()) == 0 &&
			getVerguenstigung().compareTo(that.getVerguenstigung()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getVerfuegungNr(),
			getEffektiveBetreuungPct(),
			getAnspruchPct(),
			getVerguenstigtPct(),
			getVollkosten(),
			getBetreuungsgutschein(),
			getMinimalerElternbeitrag(),
			getVerguenstigung());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", ZeitabschnittDTO.class.getSimpleName() + '[', "]")
			.add("von=" + von)
			.add("bis=" + bis)
			.toString();
	}

	@Override
	@Nonnull
	public LocalDate getVon() {
		return von;
	}

	public void setVon(@Nonnull LocalDate von) {
		this.von = von;
	}

	@Override
	@Nonnull
	public LocalDate getBis() {
		return bis;
	}

	public void setBis(@Nonnull LocalDate bis) {
		this.bis = bis;
	}

	@Override
	@Nullable
	public Integer getVerfuegungNr() {
		return verfuegungNr;
	}

	public void setVerfuegungNr(@Nullable Integer verfuegungNr) {
		this.verfuegungNr = verfuegungNr;
	}

	@Override
	@Nonnull
	public BigDecimal getEffektiveBetreuungPct() {
		return effektiveBetreuungPct;
	}

	public void setEffektiveBetreuungPct(@Nonnull BigDecimal effektiveBetreuungPct) {
		this.effektiveBetreuungPct = effektiveBetreuungPct;
	}

	@Override
	@Nonnull
	public Integer getAnspruchPct() {
		return anspruchPct;
	}

	public void setAnspruchPct(@Nonnull Integer anspruchPct) {
		this.anspruchPct = anspruchPct;
	}

	@Override
	@Nonnull
	public BigDecimal getVerguenstigtPct() {
		return verguenstigtPct;
	}

	public void setVerguenstigtPct(@Nonnull BigDecimal verguenstigtPct) {
		this.verguenstigtPct = verguenstigtPct;
	}

	@Override
	@Nonnull
	public BigDecimal getVollkosten() {
		return vollkosten;
	}

	public void setVollkosten(@Nonnull BigDecimal vollkosten) {
		this.vollkosten = vollkosten;
	}

	@Override
	@Nullable
	public BigDecimal getBetreuungsgutschein() {
		return betreuungsgutschein;
	}

	public void setBetreuungsgutschein(@Nullable BigDecimal betreuungsgutschein) {
		this.betreuungsgutschein = betreuungsgutschein;
	}

	@Override
	@Nullable
	public BigDecimal getMinimalerElternbeitrag() {
		return minimalerElternbeitrag;
	}

	public void setMinimalerElternbeitrag(@Nullable BigDecimal minimalerElternbeitrag) {
		this.minimalerElternbeitrag = minimalerElternbeitrag;
	}

	@Override
	@Nonnull
	public BigDecimal getVerguenstigung() {
		return verguenstigung;
	}

	public void setVerguenstigung(@Nonnull BigDecimal verguenstigung) {
		this.verguenstigung = verguenstigung;
	}

	@Override
	@Nullable
	public BigDecimal getVerfuegteAnzahlZeiteinheiten() {
		return verfuegteAnzahlZeiteinheiten;
	}

	public void setVerfuegteAnzahlZeiteinheiten(@Nullable BigDecimal verfuegteAnzahlZeiteinheiten) {
		this.verfuegteAnzahlZeiteinheiten = verfuegteAnzahlZeiteinheiten;
	}

	@Override
	@Nullable
	public BigDecimal getAnspruchsberechtigteAnzahlZeiteinheiten() {
		return anspruchsberechtigteAnzahlZeiteinheiten;
	}

	public void setAnspruchsberechtigteAnzahlZeiteinheiten(
		@Nullable BigDecimal anspruchsberechtigteAnzahlZeiteinheiten) {
		this.anspruchsberechtigteAnzahlZeiteinheiten = anspruchsberechtigteAnzahlZeiteinheiten;
	}

	@Override
	@Nullable
	public Zeiteinheit getZeiteinheit() {
		return zeiteinheit;
	}

	public void setZeiteinheit(@Nullable Zeiteinheit zeiteinheit) {
		this.zeiteinheit = zeiteinheit;
	}
}
