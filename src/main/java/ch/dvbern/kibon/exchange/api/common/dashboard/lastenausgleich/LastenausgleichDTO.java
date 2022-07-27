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

package ch.dvbern.kibon.exchange.api.common.dashboard.lastenausgleich;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;

public class LastenausgleichDTO implements Serializable {

	private static final long serialVersionUID = -4392319486720638816L;

	private static final Comparator<BigDecimal> BIG_DECIMAL_COMPARATOR =
		Comparator.nullsLast(Comparator.naturalOrder());

	@Nonnull
	private @NotNull Long bfsNummer;

	@Nonnull
	private @NotNull int jahr;

	@Nonnull
	private @NotNull BigDecimal eingabeLastenausgleich;

	@Nonnull
	private @NotNull BigDecimal totalGutscheine;

	public LastenausgleichDTO() {
		this.bfsNummer = 0L;
		this.jahr = 1900;
		this.eingabeLastenausgleich = BigDecimal.ZERO;
		this.totalGutscheine = BigDecimal.ZERO;
	}

	public LastenausgleichDTO(
		@Nonnull @NotNull Long bfsNummer,
		@NotNull int jahr,
		@Nonnull @NotNull BigDecimal eingabeLastenausgleich,
		@Nonnull @NotNull BigDecimal totalGutscheine) {
		this.bfsNummer = bfsNummer;
		this.jahr = jahr;
		this.eingabeLastenausgleich = eingabeLastenausgleich;
		this.totalGutscheine = totalGutscheine;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LastenausgleichDTO that = (LastenausgleichDTO) o;
		return getJahr() == that.getJahr()
			&& getBfsNummer().equals(that.getBfsNummer())
			&& BIG_DECIMAL_COMPARATOR.compare(getEingabeLastenausgleich(), that.getEingabeLastenausgleich()) == 0
			&& BIG_DECIMAL_COMPARATOR.compare(getTotalGutscheine(), that.getTotalGutscheine()) == 0;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", LastenausgleichDTO.class.getSimpleName() + '[', "]")
			.add("bfsNummer=" + bfsNummer)
			.add("jahr=" + jahr)
			.add("eingabeLastenausgleich=" + eingabeLastenausgleich)
			.add("totalGutscheine=" + totalGutscheine)
			.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBfsNummer(), getJahr(), getEingabeLastenausgleich(), getTotalGutscheine());
	}

	@Nonnull
	public Long getBfsNummer() {
		return bfsNummer;
	}

	public void setBfsNummer(@Nonnull Long bfsNummer) {
		this.bfsNummer = bfsNummer;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	@Nonnull
	public BigDecimal getEingabeLastenausgleich() {
		return eingabeLastenausgleich;
	}

	public void setEingabeLastenausgleich(@Nonnull BigDecimal eingabeLastenausgleich) {
		this.eingabeLastenausgleich = eingabeLastenausgleich;
	}

	@Nonnull
	public BigDecimal getTotalGutscheine() {
		return totalGutscheine;
	}

	public void setTotalGutscheine(@Nonnull BigDecimal totalGutscheine) {
		this.totalGutscheine = totalGutscheine;
	}
}
