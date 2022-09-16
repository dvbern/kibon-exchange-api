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

package ch.dvbern.kibon.exchange.api.common.dashboard.verfuegung;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;

import ch.dvbern.kibon.exchange.api.common.shared.EinschulungTyp;

public class KindDTO implements Serializable {

	private static final long serialVersionUID = -6175887537074736574L;

	@Nonnull
	private @NotNull String kindHash;

	@Nonnull
	private @NotNull LocalDate geburtsdatum;


	@Nonnull
	private @NotNull EinschulungTyp einschulungTyp;

	@Nonnull
	private @NotNull boolean sozialeIndikation;

	@Nonnull
	private @NotNull boolean sprachlicheIndikation;

	@Nonnull
	private @NotNull boolean sprichtMuttersprache;

	@Nonnull
	private @NotNull boolean ausserordentlicherAnspruch;

	@Nonnull
	private @NotNull boolean kindAusAsylwesenAngabeElternGemeinde;

	@Nonnull
	private @NotNull boolean keinSelbstbehaltDurchGemeinde;

	public KindDTO() {
		this.kindHash = "";
		this.geburtsdatum = LocalDate.MIN;
		this.einschulungTyp = EinschulungTyp.VORSCHULALTER;
		this.sozialeIndikation = false;
		this.sprachlicheIndikation = false;
		this.sprichtMuttersprache = true;
		this.ausserordentlicherAnspruch = false;
		this.kindAusAsylwesenAngabeElternGemeinde = false;
		this.keinSelbstbehaltDurchGemeinde = false;
	}

	public KindDTO(
		@Nonnull @NotNull String kindHash,
		@Nonnull @NotNull LocalDate geburtsdatum,
		@Nonnull @NotNull EinschulungTyp einschulungTyp,
		@NotNull boolean sozialeIndikation,
		@NotNull boolean sprachlicheIndikation,
		@NotNull boolean sprichtMuttersprache,
		@NotNull boolean ausserordentlicherAnspruch,
		@NotNull boolean kindAusAsylwesenAngabeElternGemeinde,
		@NotNull boolean keinSelbstbehaltDurchGemeinde) {
		this.kindHash = kindHash;
		this.geburtsdatum = geburtsdatum;
		this.einschulungTyp = einschulungTyp;
		this.sozialeIndikation = sozialeIndikation;
		this.sprachlicheIndikation = sprachlicheIndikation;
		this.sprichtMuttersprache = sprichtMuttersprache;
		this.ausserordentlicherAnspruch = ausserordentlicherAnspruch;
		this.kindAusAsylwesenAngabeElternGemeinde = kindAusAsylwesenAngabeElternGemeinde;
		this.keinSelbstbehaltDurchGemeinde = keinSelbstbehaltDurchGemeinde;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		KindDTO kindDTO = (KindDTO) o;
		return isSozialeIndikation() == kindDTO.isSozialeIndikation()
			&& isSprachlicheIndikation() == kindDTO.isSprachlicheIndikation()
			&& isSprichtMuttersprache() == kindDTO.isSprichtMuttersprache()
			&& getKindHash().equals(kindDTO.getKindHash())
			&& getGeburtsdatum().equals(kindDTO.getGeburtsdatum())
			&& getEinschulungTyp() == kindDTO.getEinschulungTyp()
			&& isAusserordentlicherAnspruch() == kindDTO.isAusserordentlicherAnspruch()
			&& isKindAusAsylwesenAngabeElternGemeinde() == kindDTO.isKindAusAsylwesenAngabeElternGemeinde()
			&& isKeinSelbstbehaltDurchGemeinde() == kindDTO.isKeinSelbstbehaltDurchGemeinde();
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getKindHash(),
			getGeburtsdatum(),
			getEinschulungTyp(),
			isSozialeIndikation(),
			isSprachlicheIndikation(),
			isSprichtMuttersprache(),
			isAusserordentlicherAnspruch(),
			isKindAusAsylwesenAngabeElternGemeinde(),
			isKeinSelbstbehaltDurchGemeinde());
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", KindDTO.class.getSimpleName() + '[', "]")
			.add("kindHash=" + kindHash)
			.add("geburtsdatum=" + geburtsdatum)
			.add("einschulungTyp=" + einschulungTyp)
			.add("sozialeIndikation=" + sozialeIndikation)
			.add("sprachlicheIndikation=" + sprachlicheIndikation)
			.add("sprichtMuttersprache=" + sprichtMuttersprache)
			.add("ausserordentlicherAnspruch=" + ausserordentlicherAnspruch)
			.add("kindAusAsylwesenAngabeElternGemeinde=" + kindAusAsylwesenAngabeElternGemeinde)
			.add("keinSelbstbehaltDurchGemeinde=" + keinSelbstbehaltDurchGemeinde)
			.toString();
	}

	@Nonnull
	public String getKindHash() {
		return kindHash;
	}

	public void setKindHash(@Nonnull String kindHash) {
		this.kindHash = kindHash;
	}

	@Nonnull
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(@Nonnull LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Nonnull
	public EinschulungTyp getEinschulungTyp() {
		return einschulungTyp;
	}

	public void setEinschulungTyp(@Nonnull EinschulungTyp einschulungTyp) {
		this.einschulungTyp = einschulungTyp;
	}

	public boolean isSozialeIndikation() {
		return sozialeIndikation;
	}

	public void setSozialeIndikation(boolean sozialeIndikation) {
		this.sozialeIndikation = sozialeIndikation;
	}

	public boolean isSprachlicheIndikation() {
		return sprachlicheIndikation;
	}

	public void setSprachlicheIndikation(boolean sprachlicheIndikation) {
		this.sprachlicheIndikation = sprachlicheIndikation;
	}

	public boolean isSprichtMuttersprache() {
		return sprichtMuttersprache;
	}

	public void setSprichtMuttersprache(boolean sprichtMuttersprache) {
		this.sprichtMuttersprache = sprichtMuttersprache;
	}

	public boolean isAusserordentlicherAnspruch() {
		return ausserordentlicherAnspruch;
	}

	public void setAusserordentlicherAnspruch(boolean ausserordentlicherAnspruch) {
		this.ausserordentlicherAnspruch = ausserordentlicherAnspruch;
	}

	public boolean isKindAusAsylwesenAngabeElternGemeinde() {
		return kindAusAsylwesenAngabeElternGemeinde;
	}

	public void setKindAusAsylwesenAngabeElternGemeinde(boolean kindAusAsylwesenAngabeElternGemeinde) {
		this.kindAusAsylwesenAngabeElternGemeinde = kindAusAsylwesenAngabeElternGemeinde;
	}

	public boolean isKeinSelbstbehaltDurchGemeinde() {
		return keinSelbstbehaltDurchGemeinde;
	}

	public void setKeinSelbstbehaltDurchGemeinde(boolean keinSelbstbehaltDurchGemeinde) {
		this.keinSelbstbehaltDurchGemeinde = keinSelbstbehaltDurchGemeinde;
	}
}
