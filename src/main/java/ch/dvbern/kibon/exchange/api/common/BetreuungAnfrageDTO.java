package ch.dvbern.kibon.exchange.api.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.StringJoiner;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BetreuungAnfrageDTO implements Serializable {

	private static final long serialVersionUID = 6738640790684355946L;

	@Nonnull
	private @Size(min = 1) @NotNull String referenzNummerDerBetreuung;

	@Nonnull
	private @NotNull LocalDate periodeVon;

	@Nonnull
	private @NotNull LocalDate periodeBis;

	@Nonnull
	private @Size(min = 1) @NotNull String institutionID;

	@Nonnull
	private @NotNull @Valid GesuchstellerDTO gesuchsteller;

	@Nonnull
	private @NotNull @Valid KindDTO kind;

	private boolean abgelehntVonGesuchsteller;

	public BetreuungAnfrageDTO() {
		this.referenzNummerDerBetreuung = "";
		this.periodeVon = LocalDate.MIN;
		this.periodeBis = LocalDate.MAX;
		this.institutionID = "";
		this.gesuchsteller = new GesuchstellerDTO();
		this.kind = new KindDTO();
		this.abgelehntVonGesuchsteller = false;
	}

	public BetreuungAnfrageDTO(
		@Nonnull String referenzNummerDerBetreuung,
		@Nonnull LocalDate periodeVon,
		@Nonnull LocalDate periodeBis,
		@Nonnull String institutionID,
		@Nonnull GesuchstellerDTO gesuchsteller,
		@Nonnull KindDTO kind,
		boolean abgelehntVonGesuchsteller) {
		this.referenzNummerDerBetreuung = referenzNummerDerBetreuung;
		this.periodeVon = periodeVon;
		this.periodeBis = periodeBis;
		this.institutionID = institutionID;
		this.gesuchsteller = gesuchsteller;
		this.kind = kind;
		this.abgelehntVonGesuchsteller = abgelehntVonGesuchsteller;
	}

	@Override
	@Nonnull
	public String toString() {
		return new StringJoiner(", ", BetreuungAnfrageDTO.class.getSimpleName() + '[', "]")
			.add("refnrbetreuung='" + referenzNummerDerBetreuung + '\'')
			.add("periodeVon=" + periodeVon)
			.add("periodeBis=" + periodeBis)
			.add("intitutionID=" + institutionID)
			.add("gesuchsteller=" + gesuchsteller.toString())
			.add("kind=" + kind.toString())
			.add("abgelehntVonGesuchsteller=" + abgelehntVonGesuchsteller)
			.toString();
	}

	@Nonnull
	public String getReferenzNummerDerBetreuung() {
		return referenzNummerDerBetreuung;
	}

	public void setReferenzNummerDerBetreuung(@Nonnull String referenzNummerDerBetreuung) {
		this.referenzNummerDerBetreuung = referenzNummerDerBetreuung;
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
	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(@Nonnull String institutionID) {
		this.institutionID = institutionID;
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
}
