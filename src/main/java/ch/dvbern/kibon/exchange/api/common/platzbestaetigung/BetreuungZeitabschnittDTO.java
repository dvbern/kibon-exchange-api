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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.Zeiteinheit;

public class BetreuungZeitabschnittDTO implements Serializable {

	private static final long serialVersionUID = 5776618318243644061L;

	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal betreuungskosten;

	@Nonnull
	private @NotNull @DecimalMin("0") BigDecimal betreuungspensum;

	@Nonnull
	private @NotNull LocalDate von;

	@Nonnull
	private @NotNull LocalDate bis;

	@Nonnull
	private Zeiteinheit pensumUnit;

	@Nonnull
	private @NotNull @Min(0) Integer anzahlMonatlicheHauptmahlzeiten;

	@Nonnull
	private @NotNull @Min(0) Integer anzahlMonatlicheNebenmahlzeiten;

	@Nullable
	private BigDecimal tarifProHauptmahlzeiten;

	@Nullable
	private BigDecimal tarifProNebenmahlzeiten;

	public BetreuungZeitabschnittDTO() {
		this.betreuungskosten = BigDecimal.ZERO;
		this.betreuungspensum = BigDecimal.ZERO;
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MAX;
		this.pensumUnit = Zeiteinheit.DAYS;
		this.anzahlMonatlicheHauptmahlzeiten = 0;
		this.anzahlMonatlicheNebenmahlzeiten = 0;
		this.tarifProHauptmahlzeiten = null;
		this.tarifProNebenmahlzeiten = null;
	}

	public BetreuungZeitabschnittDTO(
		@Nonnull BigDecimal betreuungskosten,
		@Nonnull BigDecimal betreuungspensum,
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nonnull Zeiteinheit pensumUnit,
		@Nonnull Integer anzahlMonatlicheHauptmahlzeiten,
		@Nonnull Integer anzahlMonatlicheNebenmahlzeiten,
		@Nullable BigDecimal tarifProHauptmahlzeiten,
		@Nullable BigDecimal tarifProNebenmahlzeiten) {
		this.betreuungskosten = betreuungskosten;
		this.betreuungspensum = betreuungspensum;
		this.von = von;
		this.bis = bis;
		this.pensumUnit = pensumUnit;
		this.anzahlMonatlicheHauptmahlzeiten = anzahlMonatlicheHauptmahlzeiten;
		this.anzahlMonatlicheNebenmahlzeiten = anzahlMonatlicheNebenmahlzeiten;
		this.tarifProHauptmahlzeiten = tarifProHauptmahlzeiten;
		this.tarifProNebenmahlzeiten = tarifProNebenmahlzeiten;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		BetreuungZeitabschnittDTO that = (BetreuungZeitabschnittDTO) o;

		return getVon().equals(that.getVon()) &&
			getBis().equals(that.getBis()) &&
			getPensumUnit() == that.getPensumUnit() &&
			getBetreuungskosten().compareTo(that.getBetreuungskosten()) == 0 &&
			getBetreuungspensum().compareTo(that.getBetreuungspensum()) == 0 &&
			getAnzahlMonatlicheHauptmahlzeiten().equals(that.getAnzahlMonatlicheHauptmahlzeiten()) &&
			getAnzahlMonatlicheNebenmahlzeiten().equals(that.getAnzahlMonatlicheNebenmahlzeiten());
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getPensumUnit(),
			getBetreuungskosten(),
			getBetreuungspensum(),
			getAnzahlMonatlicheHauptmahlzeiten(),
			getAnzahlMonatlicheNebenmahlzeiten());
	}

	@Nonnull
	public BigDecimal getBetreuungskosten() {
		return betreuungskosten;
	}

	public void setBetreuungskosten(@Nonnull BigDecimal betreuungskosten) {
		this.betreuungskosten = betreuungskosten;
	}

	@Nonnull
	public BigDecimal getBetreuungspensum() {
		return betreuungspensum;
	}

	public void setBetreuungspensum(@Nonnull BigDecimal betreuungspensum) {
		this.betreuungspensum = betreuungspensum;
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
	public Zeiteinheit getPensumUnit() {
		return pensumUnit;
	}

	public void setPensumUnit(@Nonnull Zeiteinheit pensumUnit) {
		this.pensumUnit = pensumUnit;
	}

	@Nonnull
	public Integer getAnzahlMonatlicheHauptmahlzeiten() {
		return anzahlMonatlicheHauptmahlzeiten;
	}

	public void setAnzahlMonatlicheHauptmahlzeiten(@Nonnull Integer anzahlMonatlicheHauptmahlzeiten) {
		this.anzahlMonatlicheHauptmahlzeiten = anzahlMonatlicheHauptmahlzeiten;
	}

	@Nonnull
	public Integer getAnzahlMonatlicheNebenmahlzeiten() {
		return anzahlMonatlicheNebenmahlzeiten;
	}

	public void setAnzahlMonatlicheNebenmahlzeiten(@Nonnull Integer anzahlMonatlicheNebenmahlzeiten) {
		this.anzahlMonatlicheNebenmahlzeiten = anzahlMonatlicheNebenmahlzeiten;
	}

	@Nullable
	public BigDecimal getTarifProHauptmahlzeiten() {
		return tarifProHauptmahlzeiten;
	}

	public void setTarifProHauptmahlzeiten(@Nullable BigDecimal tarifProHauptmahlzeiten) {
		this.tarifProHauptmahlzeiten = tarifProHauptmahlzeiten;
	}

	@Nullable
	public BigDecimal getTarifProNebenmahlzeiten() {
		return tarifProNebenmahlzeiten;
	}

	public void setTarifProNebenmahlzeiten(@Nullable BigDecimal tarifProNebenmahlzeiten) {
		this.tarifProNebenmahlzeiten = tarifProNebenmahlzeiten;
	}
}
