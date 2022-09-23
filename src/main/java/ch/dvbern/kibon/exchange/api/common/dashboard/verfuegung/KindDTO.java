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

package ch.dvbern.kibon.exchange.api.common.dashboard.verfuegung;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

	private boolean sozialeIndikation;

	private boolean sprachlicheIndikation;

	private boolean sprichtMuttersprache;

	private boolean ausserordentlicherAnspruch;

	private boolean kindAusAsylwesenAngabeElternGemeinde;

	private boolean keinSelbstbehaltDurchGemeinde;

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
		@Nonnull String kindHash,
		@Nonnull LocalDate geburtsdatum,
		@Nonnull EinschulungTyp einschulungTyp,
		boolean sozialeIndikation,
		boolean sprachlicheIndikation,
		boolean sprichtMuttersprache,
		boolean ausserordentlicherAnspruch,
		boolean kindAusAsylwesenAngabeElternGemeinde,
		boolean keinSelbstbehaltDurchGemeinde) {
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
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || !getClass().equals(o.getClass())) {
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
