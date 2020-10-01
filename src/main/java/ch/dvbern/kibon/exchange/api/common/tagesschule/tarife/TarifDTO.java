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

package ch.dvbern.kibon.exchange.api.common.tagesschule.tarife;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class TarifDTO implements Serializable {

	private static final long serialVersionUID = 373903231409037318L;

	@Schema(description = "Dieser Tarif gilt ab dem diesem Datum")
	@NotNull
	@Nonnull
	private LocalDate von;

	@Schema(description = "Dieser Tarif gilt bis zu dem diesem Datum")
	@NotNull
	@Nonnull
	private LocalDate bis;

	@Schema(description = "Anzahl Betreuungsminuten pro Woche")
	@NotNull
	@Min(0)
	@Nonnull
	private Integer betreuungsMinutenProWoche;

	@Schema(description = "Betreuungsgebühr pro Stunde")
	@NotNull
	@Min(0)
	@Nonnull
	private BigDecimal betreuungsKostenProStunde;

	@Schema(description = "Verpflegungskosten pro Woche")
	@NotNull
	@Min(0)
	@Nonnull
	private BigDecimal verpflegungsKostenProWoche;

	@Schema(description = "Einzelne Gemeinden subventionieren die Verpflegungskosten. Dies entspricht einem "
		+ "wöchtenlichen Rabatt.")
	@NotNull
	@Min(0)
	@Nonnull
	private BigDecimal verpflegungsKostenVerguenstigung;

	@Schema(description = "Total Kosten pro Woche")
	@NotNull
	@Min(0)
	@Nonnull
	private BigDecimal totalKostenProWoche;

	public TarifDTO() {
		this.von = LocalDate.MIN;
		this.bis = LocalDate.MAX;
		betreuungsMinutenProWoche = 0;
		betreuungsKostenProStunde = BigDecimal.ZERO;
		verpflegungsKostenProWoche = BigDecimal.ZERO;
		verpflegungsKostenVerguenstigung = BigDecimal.ZERO;
		totalKostenProWoche = BigDecimal.ZERO;
	}

	public TarifDTO(
		@Nonnull LocalDate von,
		@Nonnull LocalDate bis,
		@Nonnull Integer betreuungsMinutenProWoche,
		@Nonnull BigDecimal betreuungsKostenProStunde,
		@Nonnull BigDecimal verpflegungsKostenProWoche,
		@Nonnull BigDecimal verpflegungsKostenVerguenstigung,
		@Nonnull BigDecimal totalKostenProWoche) {
		this.von = von;
		this.bis = bis;
		this.betreuungsMinutenProWoche = betreuungsMinutenProWoche;
		this.betreuungsKostenProStunde = betreuungsKostenProStunde;
		this.verpflegungsKostenProWoche = verpflegungsKostenProWoche;
		this.verpflegungsKostenVerguenstigung = verpflegungsKostenVerguenstigung;
		this.totalKostenProWoche = totalKostenProWoche;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", TarifDTO.class.getSimpleName() + '[', "]")
			.add("von=" + von)
			.add("bis=" + bis)
			.add("betreuungsMinutenProWoche=" + betreuungsMinutenProWoche)
			.add("betreuungsKostenProStunde=" + betreuungsKostenProStunde)
			.add("verpflegungsKostenProWoche=" + verpflegungsKostenProWoche)
			.add("verpflegungsKostenVerguenstigung=" + verpflegungsKostenVerguenstigung)
			.add("totalKostenProWoche=" + totalKostenProWoche)
			.toString();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof TarifDTO)) {
			return false;
		}

		TarifDTO tarifDTO = (TarifDTO) o;

		return getVon().equals(tarifDTO.getVon()) &&
			getBis().equals(tarifDTO.getBis()) &&
			getBetreuungsMinutenProWoche().equals(tarifDTO.getBetreuungsMinutenProWoche()) &&
			getBetreuungsKostenProStunde().compareTo(tarifDTO.getBetreuungsKostenProStunde()) == 0 &&
			getVerpflegungsKostenProWoche().compareTo(tarifDTO.getVerpflegungsKostenProWoche()) == 0 &&
			getVerpflegungsKostenVerguenstigung().compareTo(tarifDTO.getVerpflegungsKostenVerguenstigung()) == 0 &&
			getTotalKostenProWoche().compareTo(tarifDTO.getTotalKostenProWoche()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getVon(),
			getBis(),
			getBetreuungsMinutenProWoche(),
			getBetreuungsKostenProStunde(),
			getVerpflegungsKostenProWoche(),
			getVerpflegungsKostenVerguenstigung(),
			getTotalKostenProWoche());
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
	public Integer getBetreuungsMinutenProWoche() {
		return betreuungsMinutenProWoche;
	}

	public void setBetreuungsMinutenProWoche(@Nonnull Integer betreuungsMinutenProWoche) {
		this.betreuungsMinutenProWoche = betreuungsMinutenProWoche;
	}

	@Nonnull
	public BigDecimal getBetreuungsKostenProStunde() {
		return betreuungsKostenProStunde;
	}

	public void setBetreuungsKostenProStunde(@Nonnull BigDecimal betreuungsKostenProStunde) {
		this.betreuungsKostenProStunde = betreuungsKostenProStunde;
	}

	@Nonnull
	public BigDecimal getVerpflegungsKostenProWoche() {
		return verpflegungsKostenProWoche;
	}

	public void setVerpflegungsKostenProWoche(@Nonnull BigDecimal verpflegungsKostenProWoche) {
		this.verpflegungsKostenProWoche = verpflegungsKostenProWoche;
	}

	@Nonnull
	public BigDecimal getVerpflegungsKostenVerguenstigung() {
		return verpflegungsKostenVerguenstigung;
	}

	public void setVerpflegungsKostenVerguenstigung(@Nonnull BigDecimal verpflegungsKostenVerguenstigung) {
		this.verpflegungsKostenVerguenstigung = verpflegungsKostenVerguenstigung;
	}

	@Nonnull
	public BigDecimal getTotalKostenProWoche() {
		return totalKostenProWoche;
	}

	public void setTotalKostenProWoche(@Nonnull BigDecimal totalKostenProWoche) {
		this.totalKostenProWoche = totalKostenProWoche;
	}
}
