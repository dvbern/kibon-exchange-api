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
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static ch.dvbern.kibon.exchange.api.common.util.ComparatorUtil.comparesEqual;

public class LastenausgleichDTO implements Serializable {

	private static final long serialVersionUID = -4392319486720638816L;

	@Schema(description = "Strikt monoton steigende ID\n\n"
		+ "Kann für Filterung mit dem `after_id` Parameter verwendet werden.")
	@Nonnull
	private @NotNull Long id;

	@Nonnull
	private @NotNull Long bfsNummer;

	@Nonnull
	private @NotNull Integer jahr;

	@Nonnull
	private @NotNull BigDecimal eingabeLastenausgleich;

	@Nonnull
	private @NotNull BigDecimal totalGutscheine;

	public LastenausgleichDTO() {
		this.id = 0L;
		this.bfsNummer = 0L;
		this.jahr = 1900;
		this.eingabeLastenausgleich = BigDecimal.ZERO;
		this.totalGutscheine = BigDecimal.ZERO;
	}

	public LastenausgleichDTO(
		@Nonnull Long id,
		@Nonnull Long bfsNummer,
		@Nonnull Integer jahr,
		@Nonnull BigDecimal eingabeLastenausgleich,
		@Nonnull BigDecimal totalGutscheine) {
		this.id = id;
		this.bfsNummer = bfsNummer;
		this.jahr = jahr;
		this.eingabeLastenausgleich = eingabeLastenausgleich;
		this.totalGutscheine = totalGutscheine;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}

		LastenausgleichDTO that = (LastenausgleichDTO) o;

		return getId().equals(that.getId())
			&& getJahr().equals(that.getJahr())
			&& getBfsNummer().equals(that.getBfsNummer())
			&& comparesEqual(getEingabeLastenausgleich(), that.getEingabeLastenausgleich())
			&& comparesEqual(getTotalGutscheine(), that.getTotalGutscheine());
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", LastenausgleichDTO.class.getSimpleName() + '[', "]")
			.add("id=" + id)
			.add("bfsNummer=" + bfsNummer)
			.add("jahr=" + jahr)
			.add("eingabeLastenausgleich=" + eingabeLastenausgleich)
			.add("totalGutscheine=" + totalGutscheine)
			.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getBfsNummer(), getJahr(), getEingabeLastenausgleich(), getTotalGutscheine());
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
	public Integer getJahr() {
		return jahr;
	}

	public void setJahr(@Nonnull Integer jahr) {
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
